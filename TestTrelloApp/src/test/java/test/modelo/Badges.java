package test.modelo;

public class Badges {
	 AttachmentsByType AttachmentsByTypeObject;
	 private boolean location;
	 private float votes;
	 private boolean viewingMemberVoted;
	 private boolean subscribed;
	 private String fogbugz;
	 private float checkItems;
	 private float checkItemsChecked;
	 private float comments;
	 private float attachments;
	 private boolean description;
	 private String due = null;
	 private boolean dueComplete;


	 // Getter Methods 

	 public AttachmentsByType getAttachmentsByType() {
	  return AttachmentsByTypeObject;
	 }

	 public boolean getLocation() {
	  return location;
	 }

	 public float getVotes() {
	  return votes;
	 }

	 public boolean getViewingMemberVoted() {
	  return viewingMemberVoted;
	 }

	 public boolean getSubscribed() {
	  return subscribed;
	 }

	 public String getFogbugz() {
	  return fogbugz;
	 }

	 public float getCheckItems() {
	  return checkItems;
	 }

	 public float getCheckItemsChecked() {
	  return checkItemsChecked;
	 }

	 public float getComments() {
	  return comments;
	 }

	 public float getAttachments() {
	  return attachments;
	 }

	 public boolean getDescription() {
	  return description;
	 }

	 public String getDue() {
	  return due;
	 }

	 public boolean getDueComplete() {
	  return dueComplete;
	 }

	 // Setter Methods 

	 public void setAttachmentsByType(AttachmentsByType attachmentsByTypeObject) {
	  this.AttachmentsByTypeObject = attachmentsByTypeObject;
	 }

	 public void setLocation(boolean location) {
	  this.location = location;
	 }

	 public void setVotes(float votes) {
	  this.votes = votes;
	 }

	 public void setViewingMemberVoted(boolean viewingMemberVoted) {
	  this.viewingMemberVoted = viewingMemberVoted;
	 }

	 public void setSubscribed(boolean subscribed) {
	  this.subscribed = subscribed;
	 }

	 public void setFogbugz(String fogbugz) {
	  this.fogbugz = fogbugz;
	 }

	 public void setCheckItems(float checkItems) {
	  this.checkItems = checkItems;
	 }

	 public void setCheckItemsChecked(float checkItemsChecked) {
	  this.checkItemsChecked = checkItemsChecked;
	 }

	 public void setComments(float comments) {
	  this.comments = comments;
	 }

	 public void setAttachments(float attachments) {
	  this.attachments = attachments;
	 }

	 public void setDescription(boolean description) {
	  this.description = description;
	 }

	 public void setDue(String due) {
	  this.due = due;
	 }

	 public void setDueComplete(boolean dueComplete) {
	  this.dueComplete = dueComplete;
	 }
	}