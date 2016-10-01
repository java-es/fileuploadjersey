package javaes.wordpress.com.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

@Component
public class UploadService {
	public String upload(String fileName, InputStream in) throws Exception {
		if (fileName == null || in == null) {
			throw new IllegalAccessException("Parâmetros inválidos");
		}
		// Pasta temporária da JVM
		File tmpDir = new File(System.getProperty("java.io.tmpdir"), "photos");
		if (!tmpDir.exists()) {
			tmpDir.mkdir();
		}
		// Cria o aqrquivo
		File file = new File(tmpDir, fileName);
		// Abre a OutputStream para escrever no arquivo
		FileOutputStream out = new FileOutputStream(file);
		// Escreve os dados no arquivo
		IOUtils.copy(in, out);
		IOUtils.closeQuietly(out);
		// Retorna o caminho do arquivo
		String path = file.getAbsolutePath();
		return path;
	}
}
