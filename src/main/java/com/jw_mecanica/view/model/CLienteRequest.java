package com.jw_mecanica.view.model;

public class CLienteRequest {
       //#region Atributos
       
    
       private String nome;
       
       private String cpf;
       
       private String telefone;
       
       private String email;
       //#endregion
       
      
   
       //#region Getters e Setters
       public String getNome() {
           return nome;
       }
   
       public void setNome(String nome) {
           this.nome = nome;
       }
   
       public String getCpf() {
           return cpf;
       }
   
       public void setCpf(String cpf) {
           this.cpf = cpf;
       }
   
       public String getTelefone() {
           return telefone;
       }
   
       public void setTelefone(String telefone) {
           this.telefone = telefone;
       }
   
       public String getEmail() {
           return email;
       }
   
       public void setEmail(String email) {
           this.email = email;
       }
   
       //#endregion
       
       
}
