package pharmacy;

import java.sql.*;

public class AddDelate {

        static Connection cnx;
        static Statement st;
        static ResultSet rst;

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {


            SupprimerParNum(3);


            try{
                cnx=connecterDB();
                st=cnx.createStatement();
                rst=st.executeQuery("SELECT * FROM medicaments");

                while(rst.next()){
                    System.out.print(rst.getInt("Num_Medicaments")+"\t");
                    System.out.print(rst.getString("Nom_Medicament")+"\t");
                    System.out.print(rst.getString("Nom_categorie")+"\t");
                    System.out.print(rst.getInt("QteEnstock")+"\t");
                    System.out.print(rst.getString("Date_Production")+"\t");
                    System.out.print(rst.getString("Date_Expedition")+"\t");
                    System.out.print(rst.getInt("Prix")+"\t");
                    System.out.println();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }

        }



        public static Connection  connecterDB(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver oki");
                String url="jdbc:mysql://localhost:3306/db_gstmedicaments";
                String user="root";
                String password="";
                Connection cnx= DriverManager.getConnection(url,user,password);
                System.out.println("Connexion bien établié");
                return cnx;
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }
        }

        public static void AddMedicaments(int Num_Medicaments,String Nom_Medicament,String Nom_categorie,int QteEnstock,String Date_Production,String Date_Expedition,int Prix){
            try{
                String query="INSERT INTO medicaments VALUES("+Num_Medicaments","+Nom_Medicament+","+Nom_categorie+","+QteEnstock+",'"+Date_Production+"',"+Date_Expedition+,+Prix+")";
                cnx=connecterDB();
                st=cnx.createStatement();
                st.executeUpdate(query);
                System.out.println("medicamets bien ajouté");

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }


        }

        public static void DelateNum(int Num_Medicaments){
            try{
                String query="DELETE FROM medicaments WHERE Num_Medicaments="+Num_Medicaments;
                cnx=connecterDB();
                st=cnx.createStatement();
                st.executeUpdate(query);
                System.out.println("medicamet bien supprimé");

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }




    }







