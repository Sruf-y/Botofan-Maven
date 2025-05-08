package Sapt_8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {
    static String url = "jdbc:mysql://localhost:3306/botofan_db";

    public static void main(String[] args) throws SQLException, IOException {


        Connection connection=null;
        connection = DriverManager.getConnection (url, "root", "root");


        String meniu = "1.Adaugare persoana de la tastatura\n2.Adaugare excursie de la tastarura\n3.Afisarea persoanelor si pt fiecare, in ce excursii a fost\n4.Afisarea excursiilor unei persoane anume\n5.Afisarea tuturor persoanelor care au fost la o locatie anume\n6.Afisarea persoanelor care au fost in excursie intr-un an anume\n7.Stergerea unei excursii\n8.Stergerea unei persoane(impreuna cu excursiile in care a fost)\n";

        int opt = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(opt>0 && opt<9){
            opt = 0;
            System.out.println(meniu);
            System.out.println("Otiunea: ");


            try {
                opt = Integer.parseInt(br.readLine());
            }catch (Exception ex){
                opt = -1;
            }

            switch (opt){
                case -1:
                    opt = 1;
                    break;



                case 1:
                    try{
                        System.out.println("Nume: ");
                        String nume = br.readLine();
                        System.out.println("Varsta: ");
                        int varsta = Integer.parseInt(br.readLine());

                        adaugarePersoana(connection,nume,varsta);
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }


                    break;

                case 2:
                    try{
                        System.out.println("Nume: ");
                        String nume = br.readLine();

                        System.out.println("Destinatie: ");
                        String destinatie = br.readLine();

                        System.out.println("An: ");
                        int an = Integer.parseInt(br.readLine());

                        adaugareExcursie(connection,nume,destinatie,an);
                    }catch(Exception ex){ex.printStackTrace();}

                    break;

                case 3:
                    afisarePersoane(connection);
                    break;

                case 4:

                    System.out.println("Nume: ");
                    String nume = br.readLine();


                    afisareExcursii_PersoanaSpeciffic(connection,nume);
                    break;



            }









            System.out.println("\n\n\n");
        }


        br.close();
        connection.close();
    }

    public static void afisareExcursii_PersoanaSpeciffic(Connection connection,String numePersoana) throws SQLException {
        ResultSet preemptivequery = doQuery(connection,"select * from persoane where nume = '"+numePersoana+"'");


        int id=-1;

        while(preemptivequery.next()){
           id = preemptivequery.getInt("id");
        }

        if(id!=-1){
            ResultSet excursie_query = doQuery(connection,"select * from excursii where id_persoana ='"+id+"'");

            while (excursie_query.next()){
                System.out.print("id = "+excursie_query.getInt(1));
                System.out.print(" id_persoana"+excursie_query.getInt(2));
                System.out.print(" destinatie"+excursie_query.getString(3));
                System.out.print(" anul"+excursie_query.getInt(4));
            }

            excursie_query.close();

            preemptivequery.close();
        }

    }


    public static void adaugareExcursie(Connection connection,String numePersoana,String destinatia, int anul) throws SQLException {
        ResultSet preemptivequery = doQuery(connection,"select * from persoane where nume = '"+numePersoana+"'");

        int pre_size = 0;
        int pre_id = 0;
        while (preemptivequery.next()){
            pre_id=preemptivequery.getInt("id");
            pre_size++;
        }



        if(pre_size==1){

            String sql = "insert into excursii (id_persoana,destinatia,anul) values (?,?,?)";

            try(PreparedStatement ps=connection.prepareStatement(sql)){
                ps.setInt(1,pre_id);
                ps.setString(2,destinatia);
                ps.setInt(3,anul);
                int nr_randuri=ps.executeUpdate();

                System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);

            }catch (SQLException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

    }

    public static void adaugarePersoana(Connection connection, String nume, int varsta) {
        String sql="insert into persoane (nume,varsta) values (?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {


            ps.setString(1, nume);
            ps.setInt(2, varsta);

            int nr_randuri=ps.executeUpdate();

            System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void afisarePersoane(Connection connection) throws SQLException {

        Statement statement;
        statement = connection.createStatement();

        String queryLine = "select * from persoane";


        ResultSet rs;
        rs = statement.executeQuery(queryLine);

        while (rs.next())
            System.out.println("id=" + rs.getInt("id") + ", nume= "
                    + rs.getString("nume") + ",varsta=" + rs.getInt("varsta"));



        statement.close();
        rs.close();
    }


    public static ResultSet doQuery(Connection connection,String line) throws SQLException {

        Statement statement;
        statement = connection.createStatement();

        ResultSet rs;
        rs = statement.executeQuery(line);





        return  rs;
    }
}
