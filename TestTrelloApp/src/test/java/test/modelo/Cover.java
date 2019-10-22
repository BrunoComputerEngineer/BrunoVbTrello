package test.modelo;

public class Cover {
	 private String idAttachment = null;
	 private String color = null;
	 private String idUploadedBackground = null;
	 private String size;
	 private String brightness;


	 // Getter Methods 

	 public String getIdAttachment() {
	  return idAttachment;
	 }

	 public String getColor() {
	  return color;
	 }

	 public String getIdUploadedBackground() {
	  return idUploadedBackground;
	 }

	 public String getSize() {
	  return size;
	 }

	 public String getBrightness() {
	  return brightness;
	 }

	 // Setter Methods 

	 public void setIdAttachment(String idAttachment) {
	  this.idAttachment = idAttachment;
	 }

	 public void setColor(String color) {
	  this.color = color;
	 }

	 public void setIdUploadedBackground(String idUploadedBackground) {
	  this.idUploadedBackground = idUploadedBackground;
	 }

	 public void setSize(String size) {
	  this.size = size;
	 }

	 public void setBrightness(String brightness) {
	  this.brightness = brightness;
	 }
	}