package com.unifacisa;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PersistenciaCSV {

	public static void main(String[] args) {
        String filePath = "dados.csv";
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File(filePath)))) {
            writer.write("Nome,Idade,Cidade\n");
            writer.write("João,25,São Paulo\n");
            writer.write("Maria,30,Rio de Janeiro\n");
            writer.write("Carlos,28,Belo Horizonte\n");
            
            System.out.println("Dados gravados com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}