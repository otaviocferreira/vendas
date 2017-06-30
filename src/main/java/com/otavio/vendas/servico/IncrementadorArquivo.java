package com.otavio.vendas.servico;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.otavio.vendas.modelo.Processamento;

public class IncrementadorArquivo {

	private static final String DIRETORIO_ARQUIVO = "c:\\PROCESSAMENTOS\\";
	private static String nomeArquivo;
	private static FileWriter arquivoAtual;
	private static PrintWriter printWriter;
	private static int linhaAtual = 1;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

	public String incrementaArquivo(Processamento processamento) {
		validaArquivoAtual();
		
		StringBuilder stringBuilder = new StringBuilder();
		
		stringBuilder.append(String.format("%010d", Integer.parseInt(""+processamento.getIdProcessamento())));
		stringBuilder.append(new SimpleDateFormat("ddMMyyyy").format(processamento.getData()));
		stringBuilder.append(String.format("%04d", Integer.parseInt(""+processamento.getLoja())));
		stringBuilder.append(String.format("%03d", Integer.parseInt(""+processamento.getPdv())));
		
		printWriter.println(stringBuilder.toString());
		
		printWriter.flush();
		
		linhaAtual++;
		
		if (linhaAtual == 11) {
			try {
				arquivoAtual.close();
			} catch (IOException e) {
				throw new RuntimeException();
			}
			
			linhaAtual = 1;
			arquivoAtual = null;
		}

		return nomeArquivo;
	}

	private void validaArquivoAtual() {
		if (arquivoAtual == null) {
			try {
				nomeArquivo = geraNomeArquivo();
				
				arquivoAtual = new FileWriter(new File(DIRETORIO_ARQUIVO + nomeArquivo));
				
				printWriter = new PrintWriter(arquivoAtual);
			} catch (IOException e) {
				throw new RuntimeException();
			}
		}
	}

	private String geraNomeArquivo() {
		StringBuilder nome = new StringBuilder();
		nome.append("processamento_");
		nome.append(sdf.format(new Date()));
		nome.append(new Random().nextInt(10));
		nome.append(".txt");

		return nome.toString();
	}
}
