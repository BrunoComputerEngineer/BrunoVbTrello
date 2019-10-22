package test.modelo;
public class BoardResponse {
 private String id;
 private String name;
 private String desc;
 private String descData = null;
 private boolean closed;
 private String idOrganization = null;
 private boolean pinned;
 private String url;
 private String shortUrl;
 Prefs PrefsObject;
 LabelNames LabelNamesObject;
 Limits LimitsObject;


 // Getter Methods 

 public String getId() {
  return id;
 }

 public String getName() {
  return name;
 }

 public String getDesc() {
  return desc;
 }

 public String getDescData() {
  return descData;
 }

 public boolean getClosed() {
  return closed;
 }

 public String getIdOrganization() {
  return idOrganization;
 }

 public boolean getPinned() {
  return pinned;
 }

 public String getUrl() {
  return url;
 }

 public String getShortUrl() {
  return shortUrl;
 }

 public Prefs getPrefs() {
  return PrefsObject;
 }

 public LabelNames getLabelNames() {
  return LabelNamesObject;
 }

 public Limits getLimits() {
  return LimitsObject;
 }

 // Setter Methods 

 public void setId(String id) {
  this.id = id;
 }

 public void setName(String name) {
  this.name = name;
 }

 public void setDesc(String desc) {
  this.desc = desc;
 }

 public void setDescData(String descData) {
  this.descData = descData;
 }

 public void setClosed(boolean closed) {
  this.closed = closed;
 }

 public void setIdOrganization(String idOrganization) {
  this.idOrganization = idOrganization;
 }

 public void setPinned(boolean pinned) {
  this.pinned = pinned;
 }

 public void setUrl(String url) {
  this.url = url;
 }

 public void setShortUrl(String shortUrl) {
  this.shortUrl = shortUrl;
 }

 public void setPrefs(Prefs prefsObject) {
  this.PrefsObject = prefsObject;
 }

 public void setLabelNames(LabelNames labelNamesObject) {
  this.LabelNamesObject = labelNamesObject;
 }

 public void setLimits(Limits limitsObject) {
  this.LimitsObject = limitsObject;
 }
}


