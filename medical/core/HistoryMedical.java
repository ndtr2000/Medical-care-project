package project.medical.core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HistoryMedical {
	private String date;
	private String typeOfVaccine;
	private int numID;
	private String address;
	private String interaction;
	private BufferedImage imageHist;
	

	public HistoryMedical(String date, String typeOfVaccine, int numID, String address, String interaction, String filename) throws IOException {
		super();
		this.date = date;
		this.typeOfVaccine = typeOfVaccine;
		this.numID = numID;
		this.address = address;
		this.interaction = interaction;
		imageHist = ImageIO.read(new File(filename));
	}
	public HistoryMedical() {
		date = null;
		typeOfVaccine = null;
		numID = 0;
		address = null;
		interaction = null;
		imageHist = null;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTypeOfVaccine() {
		return typeOfVaccine;
	}
	public void setTypeOfVaccine(String typeOfVaccine) {
		this.typeOfVaccine = typeOfVaccine;
	}
	public int getNumID() {
		return numID;
	}
	public void setNumID(int numID) {
		this.numID = numID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getInteraction() {
		return interaction;
	}
	public void setInteraction(String interaction) {
		this.interaction = interaction;
	}
	public BufferedImage getImageHist() {
		return imageHist;
	}
	public void setImageHist(BufferedImage imageHist) {
		this.imageHist = imageHist;
	}
	
	
	
}
