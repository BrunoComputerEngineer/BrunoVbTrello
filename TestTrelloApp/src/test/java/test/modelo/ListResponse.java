package test.modelo;

import java.util.ArrayList;

public class ListResponse {
	 private String id;
	 Badges BadgesObject;
	 ArrayList < Object > attachments = new ArrayList < Object > ();
	 ArrayList < Object > checkItemStates = new ArrayList < Object > ();
	 private boolean closed;
	 private boolean dueComplete;
	 private String dateLastActivity;
	 private String desc;
	 DescData DescDataObject;
	 private String due = null;
	 private String dueReminder = null;
	 private String email = null;
	 private String idBoard;
	 ArrayList < Object > idChecklists = new ArrayList < Object > ();
	 ArrayList < Object > stickers = new ArrayList < Object > ();
	 private String idList;
	 ArrayList < Object > idMembers = new ArrayList < Object > ();
	 ArrayList < Object > idMembersVoted = new ArrayList < Object > ();
	 private float idShort;
	 private String idAttachmentCover = null;
	 ArrayList < Object > labels = new ArrayList < Object > ();
	 ArrayList < Object > idLabels = new ArrayList < Object > ();
	 private boolean manualCoverAttachment;
	 private String name;
	 private float pos;
	 private String shortLink;
	 private String shortUrl;
	 private boolean subscribed;
	 private String url;
	 Cover CoverObject;
	 private boolean isTemplate;
	 Limits LimitsObject;


	 // Getter Methods 

	 public String getId() {
	  return id;
	 }

	 public Badges getBadges() {
	  return BadgesObject;
	 }

	 public boolean getClosed() {
	  return closed;
	 }

	 public boolean getDueComplete() {
	  return dueComplete;
	 }

	 public String getDateLastActivity() {
	  return dateLastActivity;
	 }

	 public String getDesc() {
	  return desc;
	 }

	 public DescData getDescData() {
	  return DescDataObject;
	 }

	 public String getDue() {
	  return due;
	 }

	 public String getDueReminder() {
	  return dueReminder;
	 }

	 public String getEmail() {
	  return email;
	 }

	 public String getIdBoard() {
	  return idBoard;
	 }

	 public String getIdList() {
	  return idList;
	 }

	 public float getIdShort() {
	  return idShort;
	 }

	 public String getIdAttachmentCover() {
	  return idAttachmentCover;
	 }

	 public boolean getManualCoverAttachment() {
	  return manualCoverAttachment;
	 }

	 public String getName() {
	  return name;
	 }

	 public float getPos() {
	  return pos;
	 }

	 public String getShortLink() {
	  return shortLink;
	 }

	 public String getShortUrl() {
	  return shortUrl;
	 }

	 public boolean getSubscribed() {
	  return subscribed;
	 }

	 public String getUrl() {
	  return url;
	 }

	 public Cover getCover() {
	  return CoverObject;
	 }

	 public boolean getIsTemplate() {
	  return isTemplate;
	 }

	 public Limits getLimits() {
	  return LimitsObject;
	 }

	 // Setter Methods 

	 public void setId(String id) {
	  this.id = id;
	 }

	 public void setBadges(Badges badgesObject) {
	  this.BadgesObject = badgesObject;
	 }

	 public void setClosed(boolean closed) {
	  this.closed = closed;
	 }

	 public void setDueComplete(boolean dueComplete) {
	  this.dueComplete = dueComplete;
	 }

	 public void setDateLastActivity(String dateLastActivity) {
	  this.dateLastActivity = dateLastActivity;
	 }

	 public void setDesc(String desc) {
	  this.desc = desc;
	 }

	 public void setDescData(DescData descDataObject) {
	  this.DescDataObject = descDataObject;
	 }

	 public void setDue(String due) {
	  this.due = due;
	 }

	 public void setDueReminder(String dueReminder) {
	  this.dueReminder = dueReminder;
	 }

	 public void setEmail(String email) {
	  this.email = email;
	 }

	 public void setIdBoard(String idBoard) {
	  this.idBoard = idBoard;
	 }

	 public void setIdList(String idList) {
	  this.idList = idList;
	 }

	 public void setIdShort(float idShort) {
	  this.idShort = idShort;
	 }

	 public void setIdAttachmentCover(String idAttachmentCover) {
	  this.idAttachmentCover = idAttachmentCover;
	 }

	 public void setManualCoverAttachment(boolean manualCoverAttachment) {
	  this.manualCoverAttachment = manualCoverAttachment;
	 }

	 public void setName(String name) {
	  this.name = name;
	 }

	 public void setPos(float pos) {
	  this.pos = pos;
	 }

	 public void setShortLink(String shortLink) {
	  this.shortLink = shortLink;
	 }

	 public void setShortUrl(String shortUrl) {
	  this.shortUrl = shortUrl;
	 }

	 public void setSubscribed(boolean subscribed) {
	  this.subscribed = subscribed;
	 }

	 public void setUrl(String url) {
	  this.url = url;
	 }

	 public void setCover(Cover coverObject) {
	  this.CoverObject = coverObject;
	 }

	 public void setIsTemplate(boolean isTemplate) {
	  this.isTemplate = isTemplate;
	 }

	 public void setLimits(Limits limitsObject) {
	  this.LimitsObject = limitsObject;
	 }
	}
	

	
	
	

	