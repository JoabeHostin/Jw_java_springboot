package com.jw_mecanica.shared;

public class ClienteDTO {
    
    //#region Atributos
    private Long id;
    
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    //#endregion
    
    
}
