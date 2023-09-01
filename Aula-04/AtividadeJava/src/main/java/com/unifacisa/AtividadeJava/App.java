package com.unifacisa.AtividadeJava;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {

    public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        List<Pessoa> pessoas = getPessoas();
        
        mapper.writeValue(new File("pessoas.json"), pessoas);
        System.out.println("Pessoas saved to pessoas.json");

        List<Pessoa> pessoasFromFile = mapper.readValue(new File("pessoas.json"), new TypeReference<List<Pessoa>>() {});
        System.out.println("Pessoas loaded from pessoas.json: " + pessoasFromFile);
    }

    private static List<Pessoa> getPessoas() {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();

        Pessoa p1 = new Pessoa();
        p1.setId(1);
        p1.setNome("Lucas");
        p1.setIdade(30); 
        p1.setEmail("lucas@gmail.com");
        p1.setEndereco("123 rua da facisa, campina grande"); 

        Pessoa p2 = new Pessoa();
        p2.setId(2);
        p2.setNome("Maria");
        p2.setIdade(28); 
        p2.setEmail("maria@gmail.com");
        p2.setEndereco("456 Av. Brasilia, Cg"); 

        Pessoa p3 = new Pessoa();
        p3.setId(3);
        p3.setNome("Jose");
        p3.setIdade(35); 
        p3.setEmail("jose@gmail.com"); 
        p3.setEndereco("789 Ed Sao Paulo, Prata"); 

        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);

        return pessoas;
    }
}
