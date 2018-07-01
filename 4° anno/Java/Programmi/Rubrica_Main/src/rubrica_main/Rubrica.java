/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rubrica_main;

/**
 *
 * @author Alessandro
 */
public class Rubrica {
    Contatto contatto[] = new Contatto[20];
    Contatto temp = new Contatto();
    private int dim=0, i, j;
    public void Ins_contatto(String nome, String cognome, String email, String telefono, String indirizzo){
        contatto[dim]=new Contatto();
        contatto[dim].nome=nome;
        contatto[dim].cognome=cognome;
        contatto[dim].email=email;
        contatto[dim].telefono=telefono;
        contatto[dim].indirizzo=indirizzo;
        dim++;
    }
        public void del_contatto(String cercare){
            j=0;
            if(dim>0){
                for(i=0;i<dim;i++){
                    if(contatto[i].telefono.compareTo(cercare)==0){
                        j++;
                        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                        while(i<dim){
                            contatto[i] = contatto[i+1];
                            i++;
                        }
                    }
                }
                dim=dim-j;
            }
            else{
                System.out.println("Inserisci prima un contatto");
            }
        }
        public void ord_cresc_nome(){
            for(int i = 0; i < dim-1; i++) {
            boolean flag = false;
            for(int j = i+1; j < dim; j++) {
                if(contatto[j].nome.compareTo(contatto[j+1].nome)<0) {
                    temp = contatto[j];
                    contatto[j] = contatto[j+1];
                    contatto[j+1] = temp;
                    flag=true;
                }
            }
            if(!flag) break;
        }
        }
        public void ord_decresc_nome(){
            for(int i = 0; i < dim-1; i++) {
            boolean flag = false;
            for(int j = i+1; j < dim; j++) {
                if(contatto[j].nome.compareTo(contatto[j+1].nome)>0) {
                    temp = contatto[j];
                    contatto[j] = contatto[j+1];
                    contatto[j+1] = temp;
                    flag=true;
                }
            }
            if(!flag) break;
            }
        }
        public void ord_cresc_cognome(){
            for(int i = 0; i < dim-1; i++) {
            boolean flag = false;
            for(int j = i+1; j < dim; j++) {
                if(contatto[j].cognome.compareTo(contatto[j+1].cognome)<0) {
                    temp = contatto[j];
                    contatto[j] = contatto[j+1];
                    contatto[j+1] = temp;
                    flag=true;
                }
            }
            if(!flag) break;
        }
        }
        public void ord_decresc_cognome(){
            for(int i = 0; i < dim-1; i++) {
            boolean flag = false;
            for(int j = i+1; j < dim-1; j++) {
                if(contatto[j].cognome.compareTo(contatto[j+1].cognome)>0) {
                    temp = contatto[j];
                    contatto[j] = contatto[j+1];
                    contatto[j+1] = temp;
                    flag=true;
                }
            }
            if(!flag) break;
        }
        }
        public void vis_cont(String cercare){
            for(i=0;i<dim;i++){
                if(contatto[i].nome.compareTo(cercare)==0){
                    System.out.println("----- Contatto " +i + "-----");
                    System.out.println("Nome: " + contatto[i].nome);
                    System.out.println("Cognome: " + contatto[i].cognome);
                    System.out.println("Telefono: " + contatto[i].telefono);
                    System.out.println("Email: " + contatto[i].email);
                    System.out.println("Indirizzo: " + contatto[i].indirizzo);
        }
            }
        }
        public void cerc_num_tel(String cercare){
            j=cercare.length();
            for(i=0;i<dim;i++){
                if(cercare.compareTo(contatto[i].telefono.substring(0,j))==0){
                    System.out.println("----- Contatto " +i + "-----");
                    System.out.println("Nome: " + contatto[i].nome);
                    System.out.println("Cognome: " + contatto[i].cognome);
                    System.out.println("Telefono: " + contatto[i].telefono);
                    System.out.println("Email: " + contatto[i].email);
                    System.out.println("Indirizzo: " + contatto[i].indirizzo);
                }
            }
        }
        public void vis_rub(){
            if(dim>0){
            for(i=0;i<dim;i++){
                System.out.println("----- Contatto " + (i+1) + "-----");
                System.out.println(contatto[i].nome);
                System.out.println(contatto[i].cognome);
                System.out.println(contatto[i].telefono);
                System.out.println(contatto[i].email);
                System.out.println(contatto[i].indirizzo);
            }
            }
        }
}
