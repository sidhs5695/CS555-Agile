import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.util.concurrent.TimeUnit;

public class GedcomParser {

    HashMap<String, String> GedMap = new HashMap<>();
    //HashMap<String, Indi> Individual = new HashMap<>();
    TreeMap<String,Indi> Individual = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int a1=Integer.valueOf(o1.substring(2,o1.length()-1));
            int a2=Integer.valueOf(o2.substring(2,o2.length()-1));
            return Integer.compare(a1,a2);
        }
    });
   // HashMap<String, Fami> Family = new HashMap<>();
    TreeMap<String, Fami> Family = new TreeMap<>(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            int a1=Integer.valueOf(o1.substring(2,o1.length()-1));
            int a2=Integer.valueOf(o2.substring(2,o2.length()-1));
            return Integer.compare(a1,a2);
        }
    });
    Boolean birt = false;
    Boolean deat = false;
    Boolean married = false;
    Boolean divorced = false;
    Indi Indiobj = null;
    Fami Famobj = null;
    String birthday;


    private static class Indi {

        String id, name, gender, bday, age, alive = "True", death = "NA", child = "NA";
        ArrayList<String> spouse = new ArrayList<>();

        public void setName(String str) {
            name = str;
        }

        public void setGender(String str) {
            gender = str;
        }

        public void setBday(String str) {

            String month="";
            String[] date=str.split(" ");
            if(date[1].equals("JAN"))
            {
                month="1";
            }
            if(date[1].equals("FEB"))
            {
                month="2";
            }
            if(date[1].equals("MAR"))
            {
                month="3";
            }
            if(date[1].equals("APR"))
            {
                month="4";
            }

            if(date[1].equals("MAY"))
            {
                month="5";
            }
            if(date[1].equals("JUN"))
            {
                month="6";
            }
            if(date[1].equals("JUL"))
            {
                month="7";
            }
            if(date[1].equals("AUG"))
            {
                month="8";
            }
            if(date[1].equals("SEP"))
            {
                month="9";
            }
            if(date[1].equals("OCT"))
            {
                month="10";
            }
            if(date[1].equals("NOV"))
            {
                month="11";
            }
            if(date[1].equals("DEC"))
            {
                month="12";
            }
            String out=date[2]+"-"+month+"-"+date[0];

            bday = out;
        }

        public String getId() {
            return id;
        }

        public void setAge(String str) {
            age = str;
        }

        public void setDeath() {
            alive = "False";
        }

        public void setDeathDay(String str) {
            String month="";
            String[] date=str.split(" ");
            if(date[1].equals("JAN"))
            {
                month="1";
            }
            if(date[1].equals("FEB"))
            {
                month="2";
            }
            if(date[1].equals("MAR"))
            {
                month="3";
            }
            if(date[1].equals("APR"))
            {
                month="4";
            }

            if(date[1].equals("MAY"))
            {
                month="5";
            }
            if(date[1].equals("JUN"))
            {
                month="6";
            }
            if(date[1].equals("JUL"))
            {
                month="7";
            }
            if(date[1].equals("AUG"))
            {
                month="8";
            }
            if(date[1].equals("SEP"))
            {
                month="9";
            }
            if(date[1].equals("OCT"))
            {
                month="10";
            }
            if(date[1].equals("NOV"))
            {
                month="11";
            }
            if(date[1].equals("DEC"))
            {
                month="12";
            }
            String out=date[2]+"-"+month+"-"+date[0];
            death = out;
        }

        public void setChild(String str) {
            child = str;
        }

        public void setSpouse(String str) {
            spouse.add(str);
        }

        public String getName() {
            return name;
        }

        public String getGender() {
            return gender;
        }

        public String getBday() {
            return bday;
        }

        public String getAge() {
            return age;
        }

        public String getAlive() {
            return alive;
        }

        public String getDeath() {
            return death;
        }

        public String getChild() {
            return child;
        }

        public ArrayList<String> getSpouse() {
            return spouse;
        }

        Indi(String str) {
            id = str;
        }

    }

    private static class Fami {

        String Fid, married, divorced = "NA", hID, hName, wID, wName;
        ArrayList<String> cSet = new ArrayList<>();

        public String getFid() {
            return Fid;
        }

        public void setFid(String fid) {
            Fid = fid;
        }

        public String getMarried() {
            return married;
        }

        public void setMarried(String married) {
           // System.out.println("");
            String month="";
            String[] date=married.split(" ");
            if(date[1].equals("JAN"))
            {
                month="1";
            }
            if(date[1].equals("FEB"))
            {
                month="2";
            }
            if(date[1].equals("MAR"))
            {
                month="3";
            }
            if(date[1].equals("APR"))
            {
                month="4";
            }

            if(date[1].equals("MAY"))
            {
                month="5";
            }
            if(date[1].equals("JUN"))
            {
                month="6";
            }
            if(date[1].equals("JUL"))
            {
                month="7";
            }
            if(date[1].equals("AUG"))
            {
                month="8";
            }
            if(date[1].equals("SEP"))
            {
                month="9";
            }
            if(date[1].equals("OCT"))
            {
                month="10";
            }
            if(date[1].equals("NOV"))
            {
                month="11";
            }
            if(date[1].equals("DEC"))
            {
                month="12";
            }
            String out=date[2]+"-"+month+"-"+date[0];
            this.married = out;
        }

        public String getDivorced() {
            return divorced;
        }

        public void setDivorced(String divorced) {
            String month="";
            String[] date=divorced.split(" ");
            if(date[1].equals("JAN"))
            {
                month="1";
            }
            if(date[1].equals("FEB"))
            {
                month="2";
            }
            if(date[1].equals("MAR"))
            {
                month="3";
            }
            if(date[1].equals("APR"))
            {
                month="4";
            }

            if(date[1].equals("MAY"))
            {
                month="5";
            }
            if(date[1].equals("JUN"))
            {
                month="6";
            }
            if(date[1].equals("JUL"))
            {
                month="7";
            }
            if(date[1].equals("AUG"))
            {
                month="8";
            }
            if(date[1].equals("SEP"))
            {
                month="9";
            }
            if(date[1].equals("OCT"))
            {
                month="10";
            }
            if(date[1].equals("NOV"))
            {
                month="11";
            }
            if(date[1].equals("DEC"))
            {
                month="12";
            }
            String out=date[2]+"-"+month+"-"+date[0];
            this.divorced = out;
        }

        public String gethID() {
            return hID;
        }

        public void sethID(String hID) {
            this.hID = hID;
        }

        public String gethName() {
            return hName;
        }

        public void sethName(String hName) {
            this.hName = hName;
        }

        public String getwID() {
            return wID;
        }

        public void setwID(String wID) {
            this.wID = wID;
        }

        public String getwName() {
            return wName;
        }

        public void setwName(String wName) {
            this.wName = wName;
        }

        public ArrayList<String> getcSet() {
            return cSet;
        }

        public void setcSet(String str) {
            cSet.add(str);
        }

        Fami(String str) {
            Fid = str;
        }


    }

    public GedcomParser() {

        GedMap.put("INDI", "0");
        GedMap.put("FAM", "0");
        GedMap.put("HEAD", "0");
        GedMap.put("TRLR", "0");
        GedMap.put("NOTE", "0");
        GedMap.put("NAME", "1");
        GedMap.put("SEX", "1");
        GedMap.put("BIRT", "1");
        GedMap.put("DEAT", "1");
        GedMap.put("FAMC", "1");
        GedMap.put("FAMS", "1");
        GedMap.put("MARR", "1");
        GedMap.put("HUSB", "1");
        GedMap.put("WIFE", "1");
        GedMap.put("CHIL", "1");
        GedMap.put("DIV", "1");
        GedMap.put("DATE", "2");

    }

    private void process(String line) {

     //   System.out.println("--> " + line);
        String[] splits;
        String valid = "N";
        String output;
        splits = line.split(" ", 3);


        if (GedMap.containsKey(splits[1])) {
            if (GedMap.get(splits[1]).equals(splits[0])) {
                valid = "Y";
                if (splits[1].equals("INDI") || splits[1].equals("FAM")) {
                    valid = "N";
                }
                try {
                    output = "<-- " + splits[0] + "|" + splits[1] + "|" + valid + "|" + splits[2];

                    this.createID(splits[2], splits[1]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    output = "<-- " + splits[0] + "|" + splits[1] + "|" + valid + "|";
                    try {
                        this.createID("", splits[1]);
                    } catch (ParseException qe) {
                        System.out.println("Parse issue"+qe+" "+splits);
                    }
                } catch (ParseException e) {
                    System.out.println("Parse issue"+e+" "+splits);
                }

            } else {
                try {
                    output = "<-- " + splits[0] + "|" + splits[1] + "|" + valid + "|" + splits[2];
                } catch (ArrayIndexOutOfBoundsException e) {
                    output = "<-- " + splits[0] + "|" + splits[1] + "|" + valid + "|";
                }
            }
        } else try {
            if (GedMap.containsKey(splits[2])) {
                if (GedMap.get(splits[2]).equals(splits[0])) {
                    valid = "Y";
                    output = "<-- " + splits[0] + "|" + splits[2] + "|" + valid + "|" + splits[1];
                    if (splits[2].equals("INDI")) {
                        String id = splits[1];
                        Indiobj = new Indi(splits[1]);
                        Individual.put(id, Indiobj);
                    } else if (splits[2].equals("FAM")) {
                        String fam = splits[1];
                        Famobj = new Fami(splits[1]);
                        Family.put(fam, Famobj);
                    }
                } else {

                    output = "<-- " + splits[0] + "|" + splits[1] + "|" + valid + "|" + splits[2];

                }
            } else {
                output = "<-- " + splits[0] + "|" + splits[1] + "|" + valid + "|" + splits[2];

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            output = "<-- " + splits[0] + "|" + splits[1] + "|" + valid + "|";
        }

        //    System.out.println(output);

    }

    public void createID(String value, String tag) throws ParseException {

        if (tag.equals("NAME")) {
            Indiobj.setName(value);
        }

        if (tag.equals("SEX")) {
            Indiobj.setGender(value);
        }

        if (birt) {
            birt = false;
            Indiobj.setBday(value);
            birthday = value;
            SimpleDateFormat f = new SimpleDateFormat("dd MMM yyyy");
            Date d = f.parse(value);
            Date c = new Date();
            long diffM = Math.abs(c.getTime() - d.getTime());
            long diff = TimeUnit.DAYS.convert(diffM, TimeUnit.MILLISECONDS);
            int years = (int) diff / 365;
            Indiobj.setAge("" + years + "");
        }

        if (tag.equals("BIRT")) {
            birt = true;
        }


        if (deat) {
            deat = false;
            Indiobj.setDeathDay(value);
            SimpleDateFormat f = new SimpleDateFormat("dd MMM yyyy");
            Date d = f.parse(value);
//            birthday = Indiobj.getBday();
            Date c = f.parse(birthday);
            long diffM = Math.abs(c.getTime() - d.getTime());
            long diff = TimeUnit.DAYS.convert(diffM, TimeUnit.MILLISECONDS);
            int years = (int) diff / 365;
            Indiobj.setAge("" + years + "");
        }

        if (tag.equals("DEAT")) {
            deat = true;
            Indiobj.setDeath();
        }

        if (tag.equals("FAMC")) {
            Indiobj.setChild(value);
        }

        if (tag.equals("FAMS")) {
            Indiobj.setSpouse(value);
        }

        //*For Family

        if (tag.equals("HUSB")) {
            Famobj.sethID(value);
            Indi x = (Indi) Individual.get(value);
            Famobj.sethName(x.getName());
        }


        if (tag.equals("WIFE")) {
            Famobj.setwID(value);
            Indi x = (Indi) Individual.get(value);
            Famobj.setwName(x.getName());
        }

        if (tag.equals("CHIL")) {
            Famobj.setcSet(value);
        }

        if (married) {
            married = false;
            Famobj.setMarried(value);
        }

        if (tag.equals("MARR")) {
            married = true;
        }

        if (divorced) {
            divorced = false;
            Famobj.setDivorced(value);
        }

        if (tag.equals("DIV")) {
            divorced = true;
        }

    }


    public void showIndiTable() {

        JFrame f = new JFrame();
        JTable tb1 = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        String align = "| %-7s | %-21s | %-8s | %-11s | %-5s | %-7s | %-11s | %-10s | %-20s|%n";
        String[] columnNames = {"ID", "Name", "Gender", "BirthDay", "Age", "Alive", "Death", "Child", "Spouse"};
        System.out.format("############################################## INDIVIDUAL TABLE ###############################################################%n");
        System.out.format("+---------+-----------------------+----------+-------------+-------+---------+-------------+------------+---------------------+%n");
        System.out.format("+ ID      | Name                  | Gender   | BirthDay    | Age   | Alive   |   Death     | Child      | Spouse              +%n");
        System.out.format("+---------+-----------------------+----------+-------------+-------+---------+-------------+------------+---------------------+%n");
       // TableList 7,21,8,11,5,7,11,10,20
        dtm.setColumnIdentifiers(columnNames);
        tb1.setModel(dtm);

        for (Map.Entry mapElement : Individual.entrySet()) {
            String key = (String) mapElement.getKey();
            Indi x = (Indi) mapElement.getValue();
            if (x.getSpouse().isEmpty()) {
                String str1 = "NA";
               Object[] InsertData = {key, x.getName(), x.getGender(), x.getBday(), x.getAge(), x.getAlive(), x.getDeath(), x.getChild(), str1};
                System.out.format(align,key,x.getName(),x.getGender(),x.getBday(),x.getAge(),x.getAlive(),x.getDeath(),x.getChild(),str1);
               dtm.addRow(InsertData);
            } else {
                Object[] InsertData = {key, x.getName(), x.getGender(), x.getBday(), x.getAge(), x.getAlive(), x.getDeath(), x.getChild(), x.getSpouse()};
                System.out.format(align,key,x.getName(),x.getGender(),x.getBday(),x.getAge(),x.getAlive(),x.getDeath(),x.getChild(),x.getSpouse());
                dtm.addRow(InsertData);
            }

        }
        System.out.format("+---------+-----------------------+----------+-------------+-------+---------+-------------+------------+---------------------+%n");
        System.out.println();
        tb1.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(tb1);
        f.add(sp);
        f.setSize(700, 200);
        f.setVisible(true);
    }

    public void showFamiTable() {

        JFrame f = new JFrame();
        JTable tb1 = new JTable();
        DefaultTableModel dtm = new DefaultTableModel(0, 0);
        String align = "| %-7s | %-10s | %-10s | %-10s | %-21s | %-7s | %-21s | %-21s |%n";
     //   String[] columnNames = {"ID", "Name", "Gender", "BirthDay", "Age", "Alive", "Death", "Child", "Spouse"};
        System.out.format("##################################################### FAMILY TABLE #################################################################%n");
        System.out.format("+---------+------------+------------+------------+-----------------------+---------+-----------------------+-----------------------+%n");
        System.out.format("+ ID      | Married    | Divorced   | Husband ID | Husband Name          | Wife ID |   Wife Name           | Children              +%n");
        System.out.format("+---------+------------+------------+------------+-----------------------+---------+-----------------------+-----------------------+%n");

        String[] columnNames = {"ID", "Married", "Divorced", "Husband ID", "Husband Name", "Wife ID", "Wife Name", "Children"};
        dtm.setColumnIdentifiers(columnNames);
        tb1.setModel(dtm);

        for (Map.Entry mapElement : Family.entrySet()) {
            String key = (String) mapElement.getKey();
            Fami x = (Fami) mapElement.getValue();
            System.out.format(align,key, x.getMarried(), x.getDivorced(), x.gethID(), x.gethName(), x.getwID(), x.getwName(), x.getcSet());
            Object[] InsertData = {key, x.getMarried(), x.getDivorced(), x.gethID(), x.gethName(), x.getwID(), x.getwName(), x.getcSet()};
            dtm.addRow(InsertData);

        }
        System.out.format("+---------+------------+------------+------------+-----------------------+---------+-----------------------+-----------------------+%n");
        tb1.setBounds(30, 40, 200, 300);
        JScrollPane sp = new JScrollPane(tb1);
        f.add(sp);
        f.setSize(700, 200);
        f.setVisible(true);
    }

    public static void main(String[] args) {

        GedcomParser lr = new GedcomParser();
        try {
            //  BufferedReader br = new BufferedReader(new FileReader("proj02test.ged"));
            BufferedReader br = new BufferedReader(new FileReader("Project01_Harishkumar_M.ged"));
            String line = null;
            while ((line = br.readLine()) != null) {
                lr.process(line);
            }

            lr.showIndiTable();
            lr.showFamiTable();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found" + e);
        } catch (IOException e) {
            System.out.println("Error in IO " + e);
        }


    }
}
