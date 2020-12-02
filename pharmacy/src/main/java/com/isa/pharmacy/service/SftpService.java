package com.isa.pharmacy.service;

import java.io.IOException;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;

public class SftpService {

	private SSHClient setup() throws IOException{
		SSHClient sshClient= new SSHClient();
		sshClient.addHostKeyVerifier(new PromiscuousVerifier());
		sshClient.connect("192.168.0.16", 22);
		sshClient.authPassword("user", "password");
		return sshClient;
	};
	
	public void downloadFile() throws IOException {
		System.out.println("Usao");
		SSHClient sshClient= setup();
		SFTPClient sftpClient= sshClient.newSFTPClient();
		String dir= "src/main/resources/";
		sftpClient.get("test.txt", dir + "test.txt");
		sftpClient.close();
		sshClient.disconnect();
	}
}