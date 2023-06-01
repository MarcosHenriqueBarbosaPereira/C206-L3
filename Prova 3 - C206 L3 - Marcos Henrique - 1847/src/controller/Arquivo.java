package controller;


import model.Professores;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Arquivo {

    public static void escrever(Professores prof){

        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try{

            os = new FileOutputStream("Professores.txt", true);

            osw = new OutputStreamWriter(os);

            bw = new BufferedWriter(osw);

            bw.write(prof.nome + ";");
            bw.write(prof.cpf + ";");
            bw.write(prof.materia);
            bw.newLine();

        }catch(Exception e){
            System.out.println(e);

        }finally {
            try {
                bw.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }


    public static ArrayList<Professores> ler(){

        ArrayList<Professores> professores = new ArrayList<>();

        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String linhaLer;

        try{

            is = new FileInputStream("Professores.txt");

            isr = new InputStreamReader(is);

            br = new BufferedReader(isr);


            linhaLer = br.readLine();
            while(linhaLer != null){
                String[] linhaQuebrada = linhaLer.split(";");
                Professores p = new Professores();
                p.nome = linhaQuebrada[0]; 
                p.cpf = linhaQuebrada[1].strip(); 
                p.materia = linhaQuebrada[2].strip();
                professores.add(p);
                linhaLer = br.readLine();
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {
            try{
                br.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return professores;
    }


    public static void remover(String cpf) {
        
        ArrayList<Professores> professores = ler();

        Iterator<Professores> iterator = professores.iterator();
        while (iterator.hasNext()) {
            Professores p = iterator.next();
            if (p.cpf.equals(cpf)) {
                iterator.remove();
                System.out.println("Professor removido!");
                break;
            }
        }

        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try {
            os = new FileOutputStream("Professores.txt", false);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            for (Professores p : professores) {
                bw.write(p.nome + ";");
                bw.write(p.cpf + ";");
                bw.write(p.materia);
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public static void mostraDados(){
        
        ArrayList<Professores> professores = ler();
        for (Professores p : professores) {
            System.out.println("Professor: " + p.nome);
            System.out.println("CPF: " + p.cpf);
            System.out.println("Matéria: " + p.materia);
            System.out.println();
        }
    }

}
