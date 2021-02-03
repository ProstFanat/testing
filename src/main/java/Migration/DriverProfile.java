package Migration;

import DB.RecordMapperValueObject;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

public class DriverProfile extends RecordMapperValueObject {
    private Long driverId;
    private Long orgId;
    private String firstName;
    private String lastName;
    private Date createDate;
    private Long refKey;
    private String status;
    private Long lcKey;
    private Character voidStamp;
    private java.sql.Date hiredDate;
    private java.sql.Date termDate;
    private String loginName;
    private String password;
    private String phone;
    private String homeTerminalTimezone;
    private Character eldExempt;
    private String licenseNumber;
    private String licenseState;
    private Character isFleetManager;
    private Integer eldMultidayBasisUsed;
    private Integer eldMultidayBasisUsedCan;
    private Integer eld24HourPeriodStartingTime;
    private Character eldIsYardMoveAllowed;
    private Character eldIsPersonalUseAllowed;
    private Integer eldSignalFrequency;
    private Character onTrip;
    private Character eldConfigurationChanged;
    private String eldExemptComment;
    private String eldEditMode;
    private String eldAppMode;
    private Date eldEventsLock;
    private String xRef; //for link from dispatch mate, contains short user name, example 'SHVETSOV'
    private String fastCardNumber;
    private Long HOSProviderId;
    private Character forAudit;
    private String gender;
    private Date birthDate;
    private Long citizenshipCountryId;
    private String countryName;
    private Character ownerOperator;
    private Long truckId;
    private Long trailerId;
    private Long ACLUserId;
    private Character useDriverAddressForHOS = 'N';
    private String addressForHOS;
    private Character eventEditingIsPermitted = 'Y';
    private Character sendPt30ErrorLog = 'N';
    private Integer tripStartMinSpeed;
    private Integer tripEndMaxSpeed;
    private Character regainHoursAtMidnight = 'N';
    private Character displayTimeOnMobileGraph = 'Y';
    private Character disable15Days = 'N';
    private Character allowEditInformation = 'N';
    private Character allowDeleteEvents = 'Y';
    private Character allowInsertEvents = 'Y';
    private Character allowEditEvents = 'Y';
    private Character allowDrivingEvents = 'Y';
    private Character dataRestriction = 'N';
    private Character lockForChange = 'N';
    private Character collectGPSWithoutTruck = 'N';
    private String autoSetToOnDuty;
    private String generateLocationDescription = "Manual";
    private Date editsOutOfSync;
    private Date inspectionReportOutOfSync;
    private Date daySummaryOutOfSync;
    private Date borderOutOfSync;
    private Long lastTripId;
    private String legalFirstName;
    private String legalLastName;
    private Character muteViolationSounds = 'N';
    private Date hiredDateAsDate;
    private Date termDateAsDate;
    private String photo;
    private Date started;
    private String hiredBy;
    private String userStamp;
    private String description;
    private Long createDateMillis;
    private String signatureImage;
    private String preferredDistanceUnit;
    private Character hasSetPreferredDistanceUnit = 'N';
    private String graphClockDisplay = "24-hour";
    private String fullName;
    private String opentextPassword;
    private Date lastLoginDateTime;
    private Character showAlertOnNewMessage = 'N';
    private Character soundNotificationOnNewMessage = 'N';
    private Character enableVoiceMessage = 'N';
    private String fileName;
    private String pin;
    private Long subscriptionId;
    private String deviceSequenceOutOfSync;
    private Date startInspection;
    private Long dispatchingSystemId;
    private Long amountOfHosVerifiedDays;
    private String email;
    private Character isDriverContractorWithPersonalAuthority = 'N';
    private String companyName;
    private String companyAddress;
    private String yardAddress;
    private String contactInfo;
    private String authorityNumbers;
    private Character eldEventsSyncRequested = 'N';
    private Character eldEventsAutoSync = 'Y';
    private Date updateDate;
    private Character onlyUsaDriving = 'N';
    private Integer appVersionMsgIntervalMin;
    private Character csvSetMilesAndHoursZeroForManualEvents;
    private Integer maxPersonalUseDistance;
    private Integer maxPersonalUseDuration;
    private Character violator = 'N';
    private String violatorComment;
    private String mobileAppOptions;
    private Long masterDBRefId;
    private Long clientDBRefId;
    private String organizationName;
    private Character sendLoadOffers = 'Y';
    //private String eldType = "teeld";

    public static final Character BOOLEAN_CHARACTER_NO = 'N';
    public static final Character BOOLEAN_CHARACTER_YES = 'Y';



    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getRefKey() {
        return refKey;
    }

    public void setRefKey(Long refKey) {
        this.refKey = refKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getLcKey() {
        return lcKey;
    }

    public void setLcKey(Long lcKey) {
        this.lcKey = lcKey;
    }

    public Character getVoidStamp() {
        return voidStamp;
    }

    public void setVoidStamp(Character voidStamp) {
        this.voidStamp = voidStamp;
    }

    public java.sql.Date getHiredDate(java.sql.Date hired_date) {
        return hiredDate;
    }

    public void setHiredDate(java.sql.Date hiredDate) {
        this.hiredDate = hiredDate;
    }

    public java.sql.Date getTermDate() {
        return termDate;
    }

    public void setTermDate(java.sql.Date termDate) {
        this.termDate = termDate;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHomeTerminalTimezone() {
        return homeTerminalTimezone;
    }

    public void setHomeTerminalTimezone(String homeTerminalTimezone) {
        this.homeTerminalTimezone = homeTerminalTimezone;
    }

    public Character getEldExempt() {
        return eldExempt;
    }

    public void setEldExempt(Character eldExempt) {
        this.eldExempt = eldExempt;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getLicenseState() {
        return licenseState;
    }

    public void setLicenseState(String licenseState) {
        this.licenseState = licenseState;
    }

    public Character getIsFleetManager() {
        return isFleetManager;
    }

    public void setIsFleetManager(Character isFleetManager) {
        this.isFleetManager = isFleetManager;
    }

    public Integer getEldMultidayBasisUsed() {
        return eldMultidayBasisUsed;
    }

    public void setEldMultidayBasisUsed(Integer eldMultidayBasisUsed) {
        this.eldMultidayBasisUsed = eldMultidayBasisUsed;
    }

    public Integer getEldMultidayBasisUsedCan() {
        return eldMultidayBasisUsedCan;
    }

    public void setEldMultidayBasisUsedCan(Integer eldMultidayBasisUsedCan) {
        this.eldMultidayBasisUsedCan = eldMultidayBasisUsedCan;
    }

    public Integer getEld24HourPeriodStartingTime() {
        return eld24HourPeriodStartingTime;
    }

    public void setEld24HourPeriodStartingTime(Integer eld24HourPeriodStartingTime) {
        this.eld24HourPeriodStartingTime = eld24HourPeriodStartingTime;
    }

    public Character getEldIsYardMoveAllowed() {
        return eldIsYardMoveAllowed;
    }

    public void setEldIsYardMoveAllowed(Character eldIsYardMoveAllowed) {
        this.eldIsYardMoveAllowed = eldIsYardMoveAllowed;
    }

    public Character getEldIsPersonalUseAllowed() {
        return eldIsPersonalUseAllowed;
    }

    public void setEldIsPersonalUseAllowed(Character eldIsPersonalUseAllowed) {
        this.eldIsPersonalUseAllowed = eldIsPersonalUseAllowed;
    }

    public Integer getEldSignalFrequency() {
        return eldSignalFrequency;
    }

    public void setEldSignalFrequency(Integer eldSignalFrequency) {
        this.eldSignalFrequency = eldSignalFrequency;
    }

    public Character getOnTrip() {
        return onTrip;
    }

    public void setOnTrip(Character onTrip) {
        this.onTrip = onTrip;
    }

    public Character getEldConfigurationChanged() {
        return eldConfigurationChanged;
    }

    public void setEldConfigurationChanged(Character eldConfigurationChanged) {
        this.eldConfigurationChanged = eldConfigurationChanged;
    }

    public String getEldExemptComment() {
        return eldExemptComment;
    }

    public void setEldExemptComment(String eldExemptComment) {
        this.eldExemptComment = eldExemptComment;
    }

    public String getEldEditMode() {
        return eldEditMode;
    }

    public void setEldEditMode(String eldEditMode) {
        this.eldEditMode = eldEditMode;
    }

    public String getEldAppMode() {
        return eldAppMode;
    }

    public void setEldAppMode(String eldAppMode) {
        this.eldAppMode = eldAppMode;
    }

    public Date getEldEventsLock() {
        return eldEventsLock;
    }

    public void setEldEventsLock(Date eldEventsLock) {
        this.eldEventsLock = eldEventsLock;
    }

    public String getxRef() {
        return xRef;
    }

    public void setxRef(String xRef) {
        this.xRef = xRef;
    }

    public String getFastCardNumber() {
        return fastCardNumber;
    }

    public void setFastCardNumber(String fastCardNumber) {
        this.fastCardNumber = fastCardNumber;
    }

    public Long getHOSProviderId() {
        return HOSProviderId;
    }

    public void setHOSProviderId(Long HOSProviderId) {
        this.HOSProviderId = HOSProviderId;
    }

    public Character getForAudit() {
        return forAudit;
    }

    public void setForAudit(Character forAudit) {
        this.forAudit = forAudit;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getCitizenshipCountryId() {
        return citizenshipCountryId;
    }

    public void setCitizenshipCountryId(Long citizenshipCountryId) {
        this.citizenshipCountryId = citizenshipCountryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Character getOwnerOperator() {
        return ownerOperator;
    }

    public void setOwnerOperator(Character ownerOperator) {
        this.ownerOperator = ownerOperator;
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }

    public Long getTrailerId() {
        return trailerId;
    }

    public void setTrailerId(Long trailerId) {
        this.trailerId = trailerId;
    }

    public Long getACLUserId() {
        return ACLUserId;
    }

    public void setACLUserId(Long ACLUserId) {
        this.ACLUserId = ACLUserId;
    }

    public Character getUseDriverAddressForHOS() {
        return useDriverAddressForHOS;
    }

    public void setUseDriverAddressForHOS(Character useDriverAddressForHOS) {
        this.useDriverAddressForHOS = useDriverAddressForHOS;
    }

    public String getAddressForHOS() {
        return addressForHOS;
    }

    public void setAddressForHOS(String addressForHOS) {
        this.addressForHOS = addressForHOS;
    }

    public Character getEventEditingIsPermitted() {
        return eventEditingIsPermitted;
    }

    public void setEventEditingIsPermitted(Character eventEditingIsPermitted) {
        this.eventEditingIsPermitted = eventEditingIsPermitted;
    }

    public Character getSendPt30ErrorLog() {
        return sendPt30ErrorLog;
    }

    public void setSendPt30ErrorLog(Character sendPt30ErrorLog) {
        this.sendPt30ErrorLog = sendPt30ErrorLog;
    }

    public Integer getTripStartMinSpeed() {
        return tripStartMinSpeed;
    }

    public void setTripStartMinSpeed(Integer tripStartMinSpeed) {
        this.tripStartMinSpeed = tripStartMinSpeed;
    }

    public Integer getTripEndMaxSpeed() {
        return tripEndMaxSpeed;
    }

    public void setTripEndMaxSpeed(Integer tripEndMaxSpeed) {
        this.tripEndMaxSpeed = tripEndMaxSpeed;
    }

    public Character getRegainHoursAtMidnight() {
        return regainHoursAtMidnight;
    }

    public void setRegainHoursAtMidnight(Character regainHoursAtMidnight) {
        this.regainHoursAtMidnight = regainHoursAtMidnight;
    }

    public Character getDisplayTimeOnMobileGraph() {
        return displayTimeOnMobileGraph;
    }

    public void setDisplayTimeOnMobileGraph(Character displayTimeOnMobileGraph) {
        this.displayTimeOnMobileGraph = displayTimeOnMobileGraph;
    }

    public Character getDisable15Days() {
        return disable15Days;
    }

    public void setDisable15Days(Character disable15Days) {
        this.disable15Days = disable15Days;
    }

    public Character getAllowEditInformation() {
        return allowEditInformation;
    }

    public void setAllowEditInformation(Character allowEditInformation) {
        this.allowEditInformation = allowEditInformation;
    }

    public Character getAllowDeleteEvents() {
        return allowDeleteEvents;
    }

    public void setAllowDeleteEvents(Character allowDeleteEvents) {
        this.allowDeleteEvents = allowDeleteEvents;
    }

    public Character getAllowInsertEvents() {
        return allowInsertEvents;
    }

    public void setAllowInsertEvents(Character allowInsertEvents) {
        this.allowInsertEvents = allowInsertEvents;
    }

    public Character getAllowEditEvents() {
        return allowEditEvents;
    }

    public void setAllowEditEvents(Character allowEditEvents) {
        this.allowEditEvents = allowEditEvents;
    }

    public Character getAllowDrivingEvents() {
        return allowDrivingEvents;
    }

    public void setAllowDrivingEvents(Character allowDrivingEvents) {
        this.allowDrivingEvents = allowDrivingEvents;
    }

    public Character getDataRestriction() {
        return dataRestriction;
    }

    public void setDataRestriction(Character dataRestriction) {
        this.dataRestriction = dataRestriction;
    }

    public Character getLockForChange() {
        return lockForChange;
    }

    public void setLockForChange(Character lockForChange) {
        this.lockForChange = lockForChange;
    }

    public Character getCollectGPSWithoutTruck() {
        return collectGPSWithoutTruck;
    }

    public void setCollectGPSWithoutTruck(Character collectGPSWithoutTruck) {
        this.collectGPSWithoutTruck = collectGPSWithoutTruck;
    }

    public String getAutoSetToOnDuty() {
        return autoSetToOnDuty;
    }

    public void setAutoSetToOnDuty(String autoSetToOnDuty) {
        this.autoSetToOnDuty = autoSetToOnDuty;
    }

    public String getGenerateLocationDescription() {
        return generateLocationDescription;
    }

    public void setGenerateLocationDescription(String generateLocationDescription) {
        this.generateLocationDescription = generateLocationDescription;
    }

    public Date getEditsOutOfSync() {
        return editsOutOfSync;
    }

    public void setEditsOutOfSync(Date editsOutOfSync) {
        this.editsOutOfSync = editsOutOfSync;
    }

    public Date getInspectionReportOutOfSync() {
        return inspectionReportOutOfSync;
    }

    public void setInspectionReportOutOfSync(Date inspectionReportOutOfSync) {
        this.inspectionReportOutOfSync = inspectionReportOutOfSync;
    }

    public Date getDaySummaryOutOfSync() {
        return daySummaryOutOfSync;
    }

    public void setDaySummaryOutOfSync(Date daySummaryOutOfSync) {
        this.daySummaryOutOfSync = daySummaryOutOfSync;
    }

    public Date getBorderOutOfSync() {
        return borderOutOfSync;
    }

    public void setBorderOutOfSync(Date borderOutOfSync) {
        this.borderOutOfSync = borderOutOfSync;
    }

    public Long getLastTripId() {
        return lastTripId;
    }

    public void setLastTripId(Long lastTripId) {
        this.lastTripId = lastTripId;
    }

    public String getLegalFirstName() {
        return legalFirstName;
    }

    public void setLegalFirstName(String legalFirstName) {
        this.legalFirstName = legalFirstName;
    }

    public String getLegalLastName() {
        return legalLastName;
    }

    public void setLegalLastName(String legalLastName) {
        this.legalLastName = legalLastName;
    }

    public Character getMuteViolationSounds() {
        return muteViolationSounds;
    }

    public void setMuteViolationSounds(Character muteViolationSounds) {
        this.muteViolationSounds = muteViolationSounds;
    }

    public Date getHiredDateAsDate() {
        return hiredDateAsDate;
    }

    public void setHiredDateAsDate(Date hiredDateAsDate) {
        this.hiredDateAsDate = hiredDateAsDate;
    }

    public Date getTermDateAsDate() {
        return termDateAsDate;
    }

    public void setTermDateAsDate(Date termDateAsDate) {
        this.termDateAsDate = termDateAsDate;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public String getHiredBy() {
        return hiredBy;
    }

    public void setHiredBy(String hiredBy) {
        this.hiredBy = hiredBy;
    }

    public String getUserStamp() {
        return userStamp;
    }

    public void setUserStamp(String userStamp) {
        this.userStamp = userStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCreateDateMillis() {
        return createDateMillis;
    }

    public void setCreateDateMillis(Long createDateMillis) {
        this.createDateMillis = createDateMillis;
    }

    public String getSignatureImage() {
        return signatureImage;
    }

    public void setSignatureImage(String signatureImage) {
        this.signatureImage = signatureImage;
    }

    public String getPreferredDistanceUnit() {
        return preferredDistanceUnit;
    }

    public void setPreferredDistanceUnit(String preferredDistanceUnit) {
        this.preferredDistanceUnit = preferredDistanceUnit;
    }

    public Character getHasSetPreferredDistanceUnit() {
        return hasSetPreferredDistanceUnit;
    }

    public void setHasSetPreferredDistanceUnit(Character hasSetPreferredDistanceUnit) {
        this.hasSetPreferredDistanceUnit = hasSetPreferredDistanceUnit;
    }

    public String getGraphClockDisplay() {
        return graphClockDisplay;
    }

    public void setGraphClockDisplay(String graphClockDisplay) {
        this.graphClockDisplay = graphClockDisplay;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getOpentextPassword() {
        return opentextPassword;
    }

    public void setOpentextPassword(String opentextPassword) {
        this.opentextPassword = opentextPassword;
    }

    public Date getLastLoginDateTime() {
        return lastLoginDateTime;
    }

    public void setLastLoginDateTime(Date lastLoginDateTime) {
        this.lastLoginDateTime = lastLoginDateTime;
    }

    public Character getShowAlertOnNewMessage() {
        return showAlertOnNewMessage;
    }

    public void setShowAlertOnNewMessage(Character showAlertOnNewMessage) {
        this.showAlertOnNewMessage = showAlertOnNewMessage;
    }

    public Character getSoundNotificationOnNewMessage() {
        return soundNotificationOnNewMessage;
    }

    public void setSoundNotificationOnNewMessage(Character soundNotificationOnNewMessage) {
        this.soundNotificationOnNewMessage = soundNotificationOnNewMessage;
    }

    public Character getEnableVoiceMessage() {
        return enableVoiceMessage;
    }

    public void setEnableVoiceMessage(Character enableVoiceMessage) {
        this.enableVoiceMessage = enableVoiceMessage;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getDeviceSequenceOutOfSync() {
        return deviceSequenceOutOfSync;
    }

    public void setDeviceSequenceOutOfSync(String deviceSequenceOutOfSync) {
        this.deviceSequenceOutOfSync = deviceSequenceOutOfSync;
    }

    public Date getStartInspection() {
        return startInspection;
    }

    public void setStartInspection(Date startInspection) {
        this.startInspection = startInspection;
    }

    public Long getDispatchingSystemId() {
        return dispatchingSystemId;
    }

    public void setDispatchingSystemId(Long dispatchingSystemId) {
        this.dispatchingSystemId = dispatchingSystemId;
    }

    public Long getAmountOfHosVerifiedDays() {
        return amountOfHosVerifiedDays;
    }

    public void setAmountOfHosVerifiedDays(Long amountOfHosVerifiedDays) {
        this.amountOfHosVerifiedDays = amountOfHosVerifiedDays;
    }

    @Override
    public String toString() {
        return "DriverProfile{" +
                "driverId=" + driverId +
                ", orgId=" + orgId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createDate=" + createDate +
                ", refKey=" + refKey +
                ", status='" + status + '\'' +
                ", lcKey=" + lcKey +
                ", voidStamp=" + voidStamp +
                ", hiredDate=" + hiredDate +
                ", termDate=" + termDate +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", homeTerminalTimezone='" + homeTerminalTimezone + '\'' +
                ", eldExempt=" + eldExempt +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", licenseState='" + licenseState + '\'' +
                ", isFleetManager=" + isFleetManager +
                ", eldMultidayBasisUsed=" + eldMultidayBasisUsed +
                ", eldMultidayBasisUsedCan=" + eldMultidayBasisUsedCan +
                ", eld24HourPeriodStartingTime=" + eld24HourPeriodStartingTime +
                ", eldIsYardMoveAllowed=" + eldIsYardMoveAllowed +
                ", eldIsPersonalUseAllowed=" + eldIsPersonalUseAllowed +
                ", eldSignalFrequency=" + eldSignalFrequency +
                ", onTrip=" + onTrip +
                ", eldConfigurationChanged=" + eldConfigurationChanged +
                ", eldExemptComment='" + eldExemptComment + '\'' +
                ", eldEditMode='" + eldEditMode + '\'' +
                ", eldAppMode='" + eldAppMode + '\'' +
                ", eldEventsLock=" + eldEventsLock +
                ", xRef='" + xRef + '\'' +
                ", fastCardNumber='" + fastCardNumber + '\'' +
                ", HOSProviderId=" + HOSProviderId +
                ", forAudit=" + forAudit +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                ", citizenshipCountryId=" + citizenshipCountryId +
                ", countryName='" + countryName + '\'' +
                ", ownerOperator=" + ownerOperator +
                ", truckId=" + truckId +
                ", trailerId=" + trailerId +
                ", ACLUserId=" + ACLUserId +
                ", useDriverAddressForHOS=" + useDriverAddressForHOS +
                ", addressForHOS='" + addressForHOS + '\'' +
                ", eventEditingIsPermitted=" + eventEditingIsPermitted +
                ", sendPt30ErrorLog=" + sendPt30ErrorLog +
                ", tripStartMinSpeed=" + tripStartMinSpeed +
                ", tripEndMaxSpeed=" + tripEndMaxSpeed +
                ", regainHoursAtMidnight=" + regainHoursAtMidnight +
                ", displayTimeOnMobileGraph=" + displayTimeOnMobileGraph +
                ", disable15Days=" + disable15Days +
                ", allowEditInformation=" + allowEditInformation +
                ", allowDeleteEvents=" + allowDeleteEvents +
                ", allowInsertEvents=" + allowInsertEvents +
                ", allowEditEvents=" + allowEditEvents +
                ", allowDrivingEvents=" + allowDrivingEvents +
                ", dataRestriction=" + dataRestriction +
                ", lockForChange=" + lockForChange +
                ", collectGPSWithoutTruck=" + collectGPSWithoutTruck +
                ", autoSetToOnDuty='" + autoSetToOnDuty + '\'' +
                ", generateLocationDescription='" + generateLocationDescription + '\'' +
                ", editsOutOfSync=" + editsOutOfSync +
                ", inspectionReportOutOfSync=" + inspectionReportOutOfSync +
                ", daySummaryOutOfSync=" + daySummaryOutOfSync +
                ", borderOutOfSync=" + borderOutOfSync +
                ", lastTripId=" + lastTripId +
                ", legalFirstName='" + legalFirstName + '\'' +
                ", legalLastName='" + legalLastName + '\'' +
                ", muteViolationSounds=" + muteViolationSounds +
                ", hiredDateAsDate=" + hiredDateAsDate +
                ", termDateAsDate=" + termDateAsDate +
                ", photo='" + photo + '\'' +
                ", started=" + started +
                ", hiredBy='" + hiredBy + '\'' +
                ", userStamp='" + userStamp + '\'' +
                ", description='" + description + '\'' +
                ", createDateMillis=" + createDateMillis +
                ", signatureImage='" + signatureImage + '\'' +
                ", preferredDistanceUnit='" + preferredDistanceUnit + '\'' +
                ", hasSetPreferredDistanceUnit=" + hasSetPreferredDistanceUnit +
                ", graphClockDisplay='" + graphClockDisplay + '\'' +
                ", fullName='" + fullName + '\'' +
                ", opentextPassword='" + opentextPassword + '\'' +
                ", lastLoginDateTime=" + lastLoginDateTime +
                ", showAlertOnNewMessage=" + showAlertOnNewMessage +
                ", soundNotificationOnNewMessage=" + soundNotificationOnNewMessage +
                ", enableVoiceMessage=" + enableVoiceMessage +
                ", fileName='" + fileName + '\'' +
                ", pin='" + pin + '\'' +
                ", subscriptionId=" + subscriptionId +
                ", deviceSequenceOutOfSync='" + deviceSequenceOutOfSync + '\'' +
                ", startInspection=" + startInspection +
                ", dispatchingSystemId=" + dispatchingSystemId +
                ", amountOfHosVerifiedDays=" + amountOfHosVerifiedDays +
                ", email='" + email + '\'' +
                ", isDriverContractorWithPersonalAuthority=" + isDriverContractorWithPersonalAuthority +
                ", companyName='" + companyName + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", yardAddress='" + yardAddress + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", authorityNumbers='" + authorityNumbers + '\'' +
                ", eldEventsSyncRequested=" + eldEventsSyncRequested +
                ", eldEventsAutoSync=" + eldEventsAutoSync +
                ", updateDate=" + updateDate +
                ", onlyUsaDriving=" + onlyUsaDriving +
                ", appVersionMsgIntervalMin=" + appVersionMsgIntervalMin +
                ", csvSetMilesAndHoursZeroForManualEvents=" + csvSetMilesAndHoursZeroForManualEvents +
                ", maxPersonalUseDistance=" + maxPersonalUseDistance +
                ", maxPersonalUseDuration=" + maxPersonalUseDuration +
                ", violator=" + violator +
                ", violatorComment='" + violatorComment + '\'' +
                ", mobileAppOptions='" + mobileAppOptions + '\'' +
                ", masterDBRefId=" + masterDBRefId +
                ", clientDBRefId=" + clientDBRefId +
                ", organizationName='" + organizationName + '\'' +
                ", sendLoadOffers=" + sendLoadOffers +
                //", eldType='" + eldType + '\'' +
                '}';
    }

    public DriverProfile(final ResultSet rs, Set<String> rsColumns) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        //this.driverId = getLong(rs, "driver_id", rsColumns);                                                                                                            //		addVOField("driver_id", Types.BIGINT, "setDriverId", Long.class, "getDriverId");
        this.orgId = getLong(rs, "org_id", rsColumns);                                                                                                                  // 		addVOField("org_id", Types.BIGINT, "setOrgId", Long.class, "getOrgId");
        this.firstName = getString(rs, "first_name", rsColumns);                                                                                                        //		addVOField("first_name", Types.VARCHAR, "setFirstName", String.class, "getFirstName");
        this.lastName = getString(rs, "last_name", rsColumns);                                                                                                          //		addVOField("last_name", Types.VARCHAR, "setLastName", String.class, "getLastName");
        //this.createDate = getDate(rs, "create_date", rsColumns);                                                                                                        //		addVOField("create_date", Types.TIMESTAMP, "setCreateDate", Date.class, "getCreateDate");
        this.refKey = getLong(rs, "ref_key", rsColumns);                                                                                                                //		addVOField("ref_key", Types.BIGINT, "setRefKey", Long.class, "getRefKey");
        this.status = getString(rs, "status", rsColumns);                                                                                                               //		addVOField("status", Types.VARCHAR, "setStatus", String.class, "getStatus");
        this.lcKey = getLong(rs, "lc_key", rsColumns);                                                                                                                  //		addVOField("lc_key", Types.BIGINT, "setLcKey", Long.class, "getLcKey");
        this.voidStamp = getCharacter(rs, "void_stamp", rsColumns);                                                                                                     //		addVOField("void_stamp", Types.CHAR, "setVoidStamp", Character.class, "getVoidStamp");
        this.hiredDateAsDate = getDate(rs, "hired_date", rsColumns);                                                                                                    //		addVOField("hired_date", Types.TIMESTAMP, "setHiredDateAsDate", Date.class, "getHiredDateAsDate");
        this.termDateAsDate = getDate(rs, "term_date", rsColumns);                                                                                                      //		addVOField("term_date", Types.TIMESTAMP, "setTermDateAsDate", Date.class, "getTermDateAsDate");
        this.started = getDate(rs, "started", rsColumns);                                                                                                               //		addVOField("started", Types.TIMESTAMP, "setStarted", Date.class, "getStarted");
        this.hiredBy = getString(rs, "hired_by", rsColumns);                                                                                                            //		addVOField("hired_by", Types.VARCHAR, "setHiredBy", String.class, "getHiredBy");
        this.loginName = getString(rs, "login_name", rsColumns);                                                                                                        //		addVOField("login_name", Types.VARCHAR, "setLoginName", String.class, "getLoginName");
        this.password = getString(rs, "password", rsColumns);                                                                                                           //		addVOField("password", Types.VARCHAR, "setPassword", String.class, "getPassword");
        this.homeTerminalTimezone = getString(rs, "home_terminal_timezone", rsColumns);                                                                                 //		addVOField("home_terminal_timezone", Types.VARCHAR, "setHomeTerminalTimezone", String.class, "getHomeTerminalTimezone");
        this.eldExempt = getCharacter(rs, "eld_exempt", rsColumns);                                                                                                     //		addVOField("eld_exempt", Types.CHAR, "setEldExempt", Character.class, "getEldExempt");
        this.licenseNumber = getString(rs, "license_number", rsColumns);                                                                                                //		addVOField("license_number", Types.VARCHAR, "setLicenseNumber", String.class, "getLicenseNumber");
        this.licenseState = getString(rs, "license_state", rsColumns);                                                                                                  //		addVOField("license_state", Types.VARCHAR, "setLicenseState", String.class, "getLicenseState");
        this.isFleetManager = getCharacter(rs, "is_fleet_manager", rsColumns);                                                                                          //		addVOField("is_fleet_manager", Types.CHAR, "setIsFleetManager", Character.class, "getIsFleetManager");
        this.xRef = getString(rs, "x_ref", rsColumns);                                                                                                                  //		addVOField("x_ref", Types.VARCHAR, "setXRef", String.class, "getXRef");
        this.fastCardNumber = getString(rs, "fast_card_number", rsColumns);                                                                                             //		addVOField("fast_card_number", Types.VARCHAR, "setFastCardNumber", String.class, "getFastCardNumber");
        this.eldMultidayBasisUsed = getInteger(rs, "eld_multiday_basis_used", rsColumns);                                                                               //		addVOField("eld_multiday_basis_used", Types.INTEGER, "setEldMultidayBasisUsed", Integer.class, "getEldMultidayBasisUsed");
        this.eldMultidayBasisUsedCan = getInteger(rs, "eld_multiday_basis_used_can", rsColumns);                                                                        //		addVOField("eld_multiday_basis_used_can", Types.INTEGER, "setEldMultidayBasisUsedCan", Integer.class, "getEldMultidayBasisUsedCan");
        this.eld24HourPeriodStartingTime = getInteger(rs, "eld_24_hour_period_starting_time", rsColumns);                                                               //		addVOField("eld_24_hour_period_starting_time", Types.INTEGER, "setEld24HourPeriodStartingTime", Integer.class, "getEld24HourPeriodStartingTime");
        this.eldIsYardMoveAllowed = getCharacter(rs, "eld_is_yard_move_allowed", rsColumns);                                                                            //		addVOField("eld_is_yard_move_allowed", Types.CHAR, "setEldIsYardMoveAllowed", Character.class, "getEldIsYardMoveAllowed");
        this.eldIsPersonalUseAllowed = getCharacter(rs, "eld_is_personal_use_allowed", rsColumns);                                                                      //		addVOField("eld_is_personal_use_allowed", Types.CHAR, "setEldIsPersonalUseAllowed", Character.class, "getEldIsPersonalUseAllowed");
        this.eldSignalFrequency = getInteger(rs, "eld_signal_frequency", rsColumns);                                                                                    //		addVOField("eld_signal_frequency", Types.INTEGER, "setEldSignalFrequency", Integer.class, "getEldSignalFrequency");
        this.onTrip = getCharacter(rs, "on_trip", rsColumns);                                                                                                           //		addVOField("on_trip", Types.CHAR, "setOnTrip", Character.class, "getOnTrip");
        this.eldConfigurationChanged = getCharacter(rs, "eld_configuration_changed", rsColumns);                                                                        //		addVOField("eld_configuration_changed", Types.CHAR, "setEldConfigurationChanged", Character.class, "getEldConfigurationChanged");
        this.eldExemptComment = getString(rs, "eld_exempt_comment", rsColumns);                                                                                         //		addVOField("eld_exempt_comment", Types.VARCHAR, "setEldExemptComment", String.class, "getEldExemptComment");
        this.eldEditMode = getString(rs, "eld_edit_mode", rsColumns);                                                                                                   //		addVOField("eld_edit_mode", Types.VARCHAR, "setEldEditMode", String.class, "getEldEditMode");
        this.eldAppMode = getString(rs, "eld_app_mode", rsColumns);                                                                                                     //		addVOField("eld_app_mode", Types.VARCHAR, "setEldAppMode", String.class, "getEldAppMode");
        this.email = getString(rs, "email", rsColumns);                                                                                                                 //		addVOField("email", Types.VARCHAR, "setEmail", String.class, "getEmail");
        //this.HOSProviderId = getLong(rs, "hos_provider_id", rsColumns);                                                                                                 //		addVOField("hos_provider_id", Types.BIGINT, "setHOSProviderId", Long.class, "getHOSProviderId");
        this.forAudit = getCharacter(rs, "for_audit", rsColumns);                                                                                                       //		addVOField("for_audit", Types.CHAR, "setForAudit", Character.class, "getForAudit");
        this.gender = getString(rs, "gender", rsColumns);                                                                                                               //		addVOField("gender", Types.VARCHAR, "setGender", String.class, "getGender");
        this.birthDate = getDate(rs, "birth_date", rsColumns);                                                                                                          //		addVOField("birth_date", Types.TIMESTAMP, "setBirthDate", Date.class, "getBirthDate");
        //this.citizenshipCountryId = getLong(rs, "citizenship_country_id", rsColumns);                                                                                   //		addVOField("citizenship_country_id", Types.BIGINT, "setCitizenshipCountryId", Long.class, "getCitizenshipCountryId");
        this.countryName = getString(rs, "country_name", rsColumns);                                                                                                    //		addVOField("country_name", Types.VARCHAR, "setCountryName", String.class, "getCountryName");
        this.isDriverContractorWithPersonalAuthority = getCharacter(rs, "is_driver_contractor_with_personal_authority", rsColumns, BOOLEAN_CHARACTER_NO);  //		addVOField("is_driver_contractor_with_personal_authority", Types.CHAR, "setIsDriverContractorWithPersonalAuthority", Character.class, "getIsDriverContractorWithPersonalAuthority");
        this.companyName = getString(rs, "company_name", rsColumns);                                                                                                    //		addVOField("company_name", Types.VARCHAR, "setCompanyName", String.class, "getCompanyName");
        this.companyAddress = getString(rs, "company_address", rsColumns);                                                                                              //		addVOField("company_address", Types.VARCHAR, "setCompanyAddress", String.class, "getCompanyAddress");
        this.yardAddress = getString(rs, "yard_address", rsColumns);                                                                                                    //		addVOField("yard_address", Types.VARCHAR, "setYardAddress", String.class, "getYardAddress");
        this.contactInfo = getString(rs, "contact_info", rsColumns);                                                                                                    //		addVOField("contact_info", Types.VARCHAR, "setContactInfo", String.class, "getContactInfo");
        this.authorityNumbers = getString(rs, "authority_numbers", rsColumns);                                                                                          //		addVOField("authority_numbers", Types.VARCHAR, "setAuthorityNumbers", String.class, "getAuthorityNumbers");
        this.signatureImage = getString(rs, "signature_image", rsColumns);                                                                                              //		addVOField("signature_image", Types.VARCHAR, "setSignatureImage", String.class, "getSignatureImage");
        this.eldEventsLock = getDate(rs, "eld_events_lock", rsColumns);                                                                                                 //		addVOField("eld_events_lock", Types.TIMESTAMP, "setEldEventsLock", Date.class, "getEldEventsLock");
        this.ownerOperator = getCharacter(rs, "owner_operator", rsColumns);                                                                                             //		addVOField("owner_operator", Types.CHAR, "setOwnerOperator", Character.class, "getOwnerOperator");
       // this.truckId = getLong(rs, "truck_id", rsColumns);                                                                                                              //		addVOField("truck_id", Types.BIGINT, "setTruckId", Long.class, "getTruckId");
       // this.trailerId = getLong(rs, "trailer_id", rsColumns);                                                                                                          //		addVOField("trailer_id", Types.BIGINT, "setTrailerId", Long.class, "getTrailerId");
        this.preferredDistanceUnit = getString(rs, "preferred_distance_unit", rsColumns);                                                                               //		addVOField("preferred_distance_unit", Types.VARCHAR, "setPreferredDistanceUnit", String.class, "getPreferredDistanceUnit");
        this.hasSetPreferredDistanceUnit = getCharacter(rs, "has_set_preferred_distance_unit", rsColumns, BOOLEAN_CHARACTER_NO);                           //		addVOField("has_set_preferred_distance_unit", Types.CHAR, "setHasSetPreferredDistanceUnit", Character.class, "getHasSetPreferredDistanceUnit");
        this.opentextPassword = getString(rs, "opentext_password", rsColumns);                                                                                          //		addVOField("opentext_password", Types.VARCHAR, "setOpentextPassword", String.class, "getOpentextPassword");
       // this.ACLUserId = getLong(rs, "acl_user_id", rsColumns);                                                                                                         //		addVOField("acl_user_id", Types.BIGINT, "setACLUserId", Long.class, "getACLUserId");
        this.useDriverAddressForHOS = getCharacter(rs, "use_address_for_hos", rsColumns, BOOLEAN_CHARACTER_NO);                                            //		addVOField("use_address_for_hos", Types.CHAR, "setUseDriverAddressForHOS", Character.class, "getUseDriverAddressForHOS");
        this.addressForHOS = getString(rs, "address_for_hos", rsColumns);                                                                                               //		addVOField("address_for_hos", Types.VARCHAR, "setAddressForHOS", String.class, "getAddressForHOS");
        this.eventEditingIsPermitted = getCharacter(rs, "event_editing_is_permitted", rsColumns, BOOLEAN_CHARACTER_YES);                                   //		addVOField("event_editing_is_permitted", Types.CHAR, "setEventEditingIsPermitted", Character.class, "getEventEditingIsPermitted");
        this.graphClockDisplay = getString(rs, "graph_clock_display", rsColumns, "24-hour");                                                                 //		addVOField("graph_clock_display", Types.VARCHAR, "setGraphClockDisplay", String.class, "getGraphClockDisplay");
        this.sendPt30ErrorLog = getCharacter(rs, "send_pt30_error_log", rsColumns, BOOLEAN_CHARACTER_NO);                                                  //		addVOField("send_pt30_error_log", Types.CHAR, "setSendPt30ErrorLog", Character.class, "getSendPt30ErrorLog");
        this.tripStartMinSpeed = getInteger(rs, "trip_start_min_speed", rsColumns);                                                                                     //		addVOField("trip_start_min_speed", Types.INTEGER, "setTripStartMinSpeed", Integer.class, "getTripStartMinSpeed");
        this.tripEndMaxSpeed = getInteger(rs, "trip_end_max_speed", rsColumns);                                                                                     //		addVOField("trip_start_min_speed", Types.INTEGER, "setTripStartMinSpeed", Integer.class, "getTripStartMinSpeed");
        this.regainHoursAtMidnight = getCharacter(rs, "regain_hours_at_midnight", rsColumns, BOOLEAN_CHARACTER_NO);                                        //		addVOField("regain_hours_at_midnight", Types.CHAR, "setRegainHoursAtMidnight", Character.class, "getRegainHoursAtMidnight");
        this.dataRestriction = getCharacter(rs, "data_restriction", rsColumns, BOOLEAN_CHARACTER_NO);                                                      //		addVOField("data_restriction", Types.CHAR, "setDataRestriction", Character.class, "getDataRestriction");
        this.lockForChange = getCharacter(rs, "lock_for_change", rsColumns, BOOLEAN_CHARACTER_NO);                                                         //		addVOField("lock_for_change", Types.CHAR, "setLockForChange", Character.class, "getLockForChange");
       // this.lastLoginDateTime = getDate(rs, "last_login_date_time", rsColumns);                                                                                        //		addVOField("last_login_date_time", Types.TIMESTAMP, "setLastLoginDateTime", Date.class, "getLastLoginDateTime");
        this.phone = getString(rs, "phone", rsColumns);                                                                                                                 //		addVOField("phone", Types.VARCHAR, "setPhone", String.class, "getPhone");
        this.autoSetToOnDuty = getString(rs, "auto_set_to_on_duty", rsColumns);                                                                                         //		addVOField("auto_set_to_on_duty", Types.VARCHAR, "setAutoSetToOnDuty", String.class, "getAutoSetToOnDuty");
        this.displayTimeOnMobileGraph = getCharacter(rs, "display_time_on_mobile_graph", rsColumns, BOOLEAN_CHARACTER_YES);								//		addVOField("display_time_on_mobile_graph", Types.CHAR, "setDisplayTimeOnMobileGraph", Character.class, "getDisplayTimeOnMobileGraph");
        this.disable15Days = getCharacter(rs, "disable_15_days", rsColumns, BOOLEAN_CHARACTER_NO);															//      addVOField("disable_15_days", Types.CHAR, "setDisable15Days", Character.class, "getDisable15Days");
        this.allowEditInformation = getCharacter(rs, "allow_edit_information", rsColumns, BOOLEAN_CHARACTER_NO);
        this.allowDeleteEvents = getCharacter(rs, "allow_delete_events", rsColumns, BOOLEAN_CHARACTER_YES);
        this.allowInsertEvents = getCharacter(rs, "allow_insert_events", rsColumns, BOOLEAN_CHARACTER_YES);
        this.allowEditEvents = getCharacter(rs, "allow_edit_events", rsColumns, BOOLEAN_CHARACTER_YES);
        this.allowDrivingEvents = getCharacter(rs, "allow_driving_events", rsColumns, BOOLEAN_CHARACTER_YES);
        this.collectGPSWithoutTruck = getCharacter(rs, "collect_gps_without_truck", rsColumns, BOOLEAN_CHARACTER_NO);
        this.generateLocationDescription = getString(rs, "generate_location_description", rsColumns, "Manual");														//		addVOField("generate_location_description", Types.VARCHAR, "setGenerateLocationDescription", String.class, "getGenerateLocationDescription");
        this.editsOutOfSync = getDate(rs, "edits_out_of_sync", rsColumns);
        this.inspectionReportOutOfSync = getDate(rs, "inspection_report_out_of_sync", rsColumns);
        this.daySummaryOutOfSync = getDate(rs, "day_summary_out_of_sync", rsColumns);
        this.borderOutOfSync = getDate(rs, "border_out_of_sync", rsColumns);
        this.eldEventsSyncRequested = getCharacter(rs, "eld_events_sync_requested", rsColumns, BOOLEAN_CHARACTER_NO);
        this.eldEventsAutoSync = getCharacter(rs, "eld_events_auto_sync", rsColumns, BOOLEAN_CHARACTER_YES);
        this.showAlertOnNewMessage = getCharacter(rs, "show_alert_on_new_message", rsColumns, BOOLEAN_CHARACTER_NO);
        this.soundNotificationOnNewMessage = getCharacter(rs, "sound_notification_on_new_message", rsColumns, BOOLEAN_CHARACTER_NO);
        this.enableVoiceMessage = getCharacter(rs, "enable_voice_message", rsColumns, BOOLEAN_CHARACTER_NO);
       // this.lastTripId = getLong(rs, "last_trip_id", rsColumns);
        this.legalFirstName = getString(rs, "legal_first_name", rsColumns);
        this.legalLastName = getString(rs, "legal_last_name", rsColumns);
        this.muteViolationSounds = getCharacter(rs, "mute_violation_sounds", rsColumns, BOOLEAN_CHARACTER_NO);
        this.pin = getString(rs, "pin", rsColumns);
       // this.subscriptionId = getLong(rs, "subscription_id", rsColumns);
        this.deviceSequenceOutOfSync = getString(rs, "device_sequence_out_of_sync", rsColumns);
        this.startInspection = getDate(rs, "start_inspection", rsColumns);
       // this.updateDate = getDate(rs, "update_date", rsColumns);
        this.onlyUsaDriving = getCharacter(rs, "only_usa_driving", rsColumns, BOOLEAN_CHARACTER_NO);
       // this.dispatchingSystemId = getLong(rs, "dispatching_system_id", rsColumns);
        this.appVersionMsgIntervalMin = getInteger(rs, "app_version_msg_interval_min", rsColumns);
        this.csvSetMilesAndHoursZeroForManualEvents = getCharacter(rs, "csv_set_miles_and_hours_zero_for_manual_events", rsColumns, BOOLEAN_CHARACTER_NO);
        this.maxPersonalUseDistance = getInteger(rs, "max_personal_use_distance", rsColumns);
        this.maxPersonalUseDuration = getInteger(rs, "max_personal_use_duration", rsColumns);
        this.violator = getCharacter(rs, "violator", rsColumns);
        this.violatorComment = getString(rs, "violator_comment", rsColumns);
        this.mobileAppOptions = getString(rs, "mobile_app_options", rsColumns);
        //this.masterDBRefId = getLong(rs, "master_db_ref_id", rsColumns);
        this.clientDBRefId = getLong(rs, "client_db_ref_id", rsColumns);
        this.organizationName = getString(rs, "organization_name", rsColumns);
        this.sendLoadOffers = getCharacter(rs, "send_load_offers", rsColumns);
        this.mobileAppOptions = getString(rs, "mobile_app_options", rsColumns);
    }

    public DriverProfile(final ResultSet rs, Set<String> rsColumns, String aaaa) throws Exception {
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }

        this.driverId = getLong(rs, "driver_id", rsColumns);                                                                                                            //		addVOField("driver_id", Types.BIGINT, "setDriverId", Long.class, "getDriverId");
        this.orgId = getLong(rs, "org_id", rsColumns);                                                                                                                  // 		addVOField("org_id", Types.BIGINT, "setOrgId", Long.class, "getOrgId");
        this.firstName = getString(rs, "first_name", rsColumns);                                                                                                        //		addVOField("first_name", Types.VARCHAR, "setFirstName", String.class, "getFirstName");
        this.lastName = getString(rs, "last_name", rsColumns);                                                                                                          //		addVOField("last_name", Types.VARCHAR, "setLastName", String.class, "getLastName");
        this.createDate = getDate(rs, "create_date", rsColumns);                                                                                                        //		addVOField("create_date", Types.TIMESTAMP, "setCreateDate", Date.class, "getCreateDate");
        this.refKey = getLong(rs, "ref_key", rsColumns);                                                                                                                //		addVOField("ref_key", Types.BIGINT, "setRefKey", Long.class, "getRefKey");
        this.status = getString(rs, "status", rsColumns);                                                                                                               //		addVOField("status", Types.VARCHAR, "setStatus", String.class, "getStatus");
        this.lcKey = getLong(rs, "lc_key", rsColumns);                                                                                                                  //		addVOField("lc_key", Types.BIGINT, "setLcKey", Long.class, "getLcKey");
        this.voidStamp = getCharacter(rs, "void_stamp", rsColumns);                                                                                                     //		addVOField("void_stamp", Types.CHAR, "setVoidStamp", Character.class, "getVoidStamp");
        this.hiredDateAsDate = getDate(rs, "hired_date", rsColumns);                                                                                                    //		addVOField("hired_date", Types.TIMESTAMP, "setHiredDateAsDate", Date.class, "getHiredDateAsDate");
        this.termDateAsDate = getDate(rs, "term_date", rsColumns);                                                                                                      //		addVOField("term_date", Types.TIMESTAMP, "setTermDateAsDate", Date.class, "getTermDateAsDate");
        this.started = getDate(rs, "started", rsColumns);                                                                                                               //		addVOField("started", Types.TIMESTAMP, "setStarted", Date.class, "getStarted");
        this.hiredBy = getString(rs, "hired_by", rsColumns);                                                                                                            //		addVOField("hired_by", Types.VARCHAR, "setHiredBy", String.class, "getHiredBy");
        this.loginName = getString(rs, "login_name", rsColumns);                                                                                                        //		addVOField("login_name", Types.VARCHAR, "setLoginName", String.class, "getLoginName");
        this.password = getString(rs, "password", rsColumns);                                                                                                           //		addVOField("password", Types.VARCHAR, "setPassword", String.class, "getPassword");
        this.homeTerminalTimezone = getString(rs, "home_terminal_timezone", rsColumns);                                                                                 //		addVOField("home_terminal_timezone", Types.VARCHAR, "setHomeTerminalTimezone", String.class, "getHomeTerminalTimezone");
        this.eldExempt = getCharacter(rs, "eld_exempt", rsColumns);                                                                                                     //		addVOField("eld_exempt", Types.CHAR, "setEldExempt", Character.class, "getEldExempt");
        this.licenseNumber = getString(rs, "license_number", rsColumns);                                                                                                //		addVOField("license_number", Types.VARCHAR, "setLicenseNumber", String.class, "getLicenseNumber");
        this.licenseState = getString(rs, "license_state", rsColumns);                                                                                                  //		addVOField("license_state", Types.VARCHAR, "setLicenseState", String.class, "getLicenseState");
        this.isFleetManager = getCharacter(rs, "is_fleet_manager", rsColumns);                                                                                          //		addVOField("is_fleet_manager", Types.CHAR, "setIsFleetManager", Character.class, "getIsFleetManager");
        this.xRef = getString(rs, "x_ref", rsColumns);                                                                                                                  //		addVOField("x_ref", Types.VARCHAR, "setXRef", String.class, "getXRef");
        this.fastCardNumber = getString(rs, "fast_card_number", rsColumns);                                                                                             //		addVOField("fast_card_number", Types.VARCHAR, "setFastCardNumber", String.class, "getFastCardNumber");
        this.eldMultidayBasisUsed = getInteger(rs, "eld_multiday_basis_used", rsColumns);                                                                               //		addVOField("eld_multiday_basis_used", Types.INTEGER, "setEldMultidayBasisUsed", Integer.class, "getEldMultidayBasisUsed");
        this.eldMultidayBasisUsedCan = getInteger(rs, "eld_multiday_basis_used_can", rsColumns);                                                                        //		addVOField("eld_multiday_basis_used_can", Types.INTEGER, "setEldMultidayBasisUsedCan", Integer.class, "getEldMultidayBasisUsedCan");
        this.eld24HourPeriodStartingTime = getInteger(rs, "eld_24_hour_period_starting_time", rsColumns);                                                               //		addVOField("eld_24_hour_period_starting_time", Types.INTEGER, "setEld24HourPeriodStartingTime", Integer.class, "getEld24HourPeriodStartingTime");
        this.eldIsYardMoveAllowed = getCharacter(rs, "eld_is_yard_move_allowed", rsColumns);                                                                            //		addVOField("eld_is_yard_move_allowed", Types.CHAR, "setEldIsYardMoveAllowed", Character.class, "getEldIsYardMoveAllowed");
        this.eldIsPersonalUseAllowed = getCharacter(rs, "eld_is_personal_use_allowed", rsColumns);                                                                      //		addVOField("eld_is_personal_use_allowed", Types.CHAR, "setEldIsPersonalUseAllowed", Character.class, "getEldIsPersonalUseAllowed");
        this.eldSignalFrequency = getInteger(rs, "eld_signal_frequency", rsColumns);                                                                                    //		addVOField("eld_signal_frequency", Types.INTEGER, "setEldSignalFrequency", Integer.class, "getEldSignalFrequency");
        this.onTrip = getCharacter(rs, "on_trip", rsColumns);                                                                                                           //		addVOField("on_trip", Types.CHAR, "setOnTrip", Character.class, "getOnTrip");
        this.eldConfigurationChanged = getCharacter(rs, "eld_configuration_changed", rsColumns);                                                                        //		addVOField("eld_configuration_changed", Types.CHAR, "setEldConfigurationChanged", Character.class, "getEldConfigurationChanged");
        this.eldExemptComment = getString(rs, "eld_exempt_comment", rsColumns);                                                                                         //		addVOField("eld_exempt_comment", Types.VARCHAR, "setEldExemptComment", String.class, "getEldExemptComment");
        this.eldEditMode = getString(rs, "eld_edit_mode", rsColumns);                                                                                                   //		addVOField("eld_edit_mode", Types.VARCHAR, "setEldEditMode", String.class, "getEldEditMode");
        this.eldAppMode = getString(rs, "eld_app_mode", rsColumns);                                                                                                     //		addVOField("eld_app_mode", Types.VARCHAR, "setEldAppMode", String.class, "getEldAppMode");
        this.email = getString(rs, "email", rsColumns);                                                                                                                 //		addVOField("email", Types.VARCHAR, "setEmail", String.class, "getEmail");
        this.HOSProviderId = getLong(rs, "hos_provider_id", rsColumns);                                                                                                 //		addVOField("hos_provider_id", Types.BIGINT, "setHOSProviderId", Long.class, "getHOSProviderId");
        this.forAudit = getCharacter(rs, "for_audit", rsColumns);                                                                                                       //		addVOField("for_audit", Types.CHAR, "setForAudit", Character.class, "getForAudit");
        this.gender = getString(rs, "gender", rsColumns);                                                                                                               //		addVOField("gender", Types.VARCHAR, "setGender", String.class, "getGender");
        this.birthDate = getDate(rs, "birth_date", rsColumns);                                                                                                          //		addVOField("birth_date", Types.TIMESTAMP, "setBirthDate", Date.class, "getBirthDate");
        this.citizenshipCountryId = getLong(rs, "citizenship_country_id", rsColumns);                                                                                   //		addVOField("citizenship_country_id", Types.BIGINT, "setCitizenshipCountryId", Long.class, "getCitizenshipCountryId");
        this.countryName = getString(rs, "country_name", rsColumns);                                                                                                    //		addVOField("country_name", Types.VARCHAR, "setCountryName", String.class, "getCountryName");
        this.isDriverContractorWithPersonalAuthority = getCharacter(rs, "is_driver_contractor_with_personal_authority", rsColumns, BOOLEAN_CHARACTER_NO);  //		addVOField("is_driver_contractor_with_personal_authority", Types.CHAR, "setIsDriverContractorWithPersonalAuthority", Character.class, "getIsDriverContractorWithPersonalAuthority");
        this.companyName = getString(rs, "company_name", rsColumns);                                                                                                    //		addVOField("company_name", Types.VARCHAR, "setCompanyName", String.class, "getCompanyName");
        this.companyAddress = getString(rs, "company_address", rsColumns);                                                                                              //		addVOField("company_address", Types.VARCHAR, "setCompanyAddress", String.class, "getCompanyAddress");
        this.yardAddress = getString(rs, "yard_address", rsColumns);                                                                                                    //		addVOField("yard_address", Types.VARCHAR, "setYardAddress", String.class, "getYardAddress");
        this.contactInfo = getString(rs, "contact_info", rsColumns);                                                                                                    //		addVOField("contact_info", Types.VARCHAR, "setContactInfo", String.class, "getContactInfo");
        this.authorityNumbers = getString(rs, "authority_numbers", rsColumns);                                                                                          //		addVOField("authority_numbers", Types.VARCHAR, "setAuthorityNumbers", String.class, "getAuthorityNumbers");
        this.signatureImage = getString(rs, "signature_image", rsColumns);                                                                                              //		addVOField("signature_image", Types.VARCHAR, "setSignatureImage", String.class, "getSignatureImage");
        this.eldEventsLock = getDate(rs, "eld_events_lock", rsColumns);                                                                                                 //		addVOField("eld_events_lock", Types.TIMESTAMP, "setEldEventsLock", Date.class, "getEldEventsLock");
        this.ownerOperator = getCharacter(rs, "owner_operator", rsColumns);                                                                                             //		addVOField("owner_operator", Types.CHAR, "setOwnerOperator", Character.class, "getOwnerOperator");
        // this.truckId = getLong(rs, "truck_id", rsColumns);                                                                                                              //		addVOField("truck_id", Types.BIGINT, "setTruckId", Long.class, "getTruckId");
        // this.trailerId = getLong(rs, "trailer_id", rsColumns);                                                                                                          //		addVOField("trailer_id", Types.BIGINT, "setTrailerId", Long.class, "getTrailerId");
        this.preferredDistanceUnit = getString(rs, "preferred_distance_unit", rsColumns);                                                                               //		addVOField("preferred_distance_unit", Types.VARCHAR, "setPreferredDistanceUnit", String.class, "getPreferredDistanceUnit");
        this.hasSetPreferredDistanceUnit = getCharacter(rs, "has_set_preferred_distance_unit", rsColumns, BOOLEAN_CHARACTER_NO);                           //		addVOField("has_set_preferred_distance_unit", Types.CHAR, "setHasSetPreferredDistanceUnit", Character.class, "getHasSetPreferredDistanceUnit");
        this.opentextPassword = getString(rs, "opentext_password", rsColumns);                                                                                          //		addVOField("opentext_password", Types.VARCHAR, "setOpentextPassword", String.class, "getOpentextPassword");
        // this.ACLUserId = getLong(rs, "acl_user_id", rsColumns);                                                                                                         //		addVOField("acl_user_id", Types.BIGINT, "setACLUserId", Long.class, "getACLUserId");
        this.useDriverAddressForHOS = getCharacter(rs, "use_address_for_hos", rsColumns, BOOLEAN_CHARACTER_NO);                                            //		addVOField("use_address_for_hos", Types.CHAR, "setUseDriverAddressForHOS", Character.class, "getUseDriverAddressForHOS");
        this.addressForHOS = getString(rs, "address_for_hos", rsColumns);                                                                                               //		addVOField("address_for_hos", Types.VARCHAR, "setAddressForHOS", String.class, "getAddressForHOS");
        this.eventEditingIsPermitted = getCharacter(rs, "event_editing_is_permitted", rsColumns, BOOLEAN_CHARACTER_YES);                                   //		addVOField("event_editing_is_permitted", Types.CHAR, "setEventEditingIsPermitted", Character.class, "getEventEditingIsPermitted");
        this.graphClockDisplay = getString(rs, "graph_clock_display", rsColumns, "24-hour");                                                                 //		addVOField("graph_clock_display", Types.VARCHAR, "setGraphClockDisplay", String.class, "getGraphClockDisplay");
        this.sendPt30ErrorLog = getCharacter(rs, "send_pt30_error_log", rsColumns, BOOLEAN_CHARACTER_NO);                                                  //		addVOField("send_pt30_error_log", Types.CHAR, "setSendPt30ErrorLog", Character.class, "getSendPt30ErrorLog");
        this.tripStartMinSpeed = getInteger(rs, "trip_start_min_speed", rsColumns);                                                                                     //		addVOField("trip_start_min_speed", Types.INTEGER, "setTripStartMinSpeed", Integer.class, "getTripStartMinSpeed");
        this.tripEndMaxSpeed = getInteger(rs, "trip_end_max_speed", rsColumns);                                                                                     //		addVOField("trip_start_min_speed", Types.INTEGER, "setTripStartMinSpeed", Integer.class, "getTripStartMinSpeed");
        this.regainHoursAtMidnight = getCharacter(rs, "regain_hours_at_midnight", rsColumns, BOOLEAN_CHARACTER_NO);                                        //		addVOField("regain_hours_at_midnight", Types.CHAR, "setRegainHoursAtMidnight", Character.class, "getRegainHoursAtMidnight");
        this.dataRestriction = getCharacter(rs, "data_restriction", rsColumns, BOOLEAN_CHARACTER_NO);                                                      //		addVOField("data_restriction", Types.CHAR, "setDataRestriction", Character.class, "getDataRestriction");
        this.lockForChange = getCharacter(rs, "lock_for_change", rsColumns, BOOLEAN_CHARACTER_NO);                                                         //		addVOField("lock_for_change", Types.CHAR, "setLockForChange", Character.class, "getLockForChange");
        this.lastLoginDateTime = getDate(rs, "last_login_date_time", rsColumns);                                                                                        //		addVOField("last_login_date_time", Types.TIMESTAMP, "setLastLoginDateTime", Date.class, "getLastLoginDateTime");
        this.phone = getString(rs, "phone", rsColumns);                                                                                                                 //		addVOField("phone", Types.VARCHAR, "setPhone", String.class, "getPhone");
        this.autoSetToOnDuty = getString(rs, "auto_set_to_on_duty", rsColumns);                                                                                         //		addVOField("auto_set_to_on_duty", Types.VARCHAR, "setAutoSetToOnDuty", String.class, "getAutoSetToOnDuty");
        this.displayTimeOnMobileGraph = getCharacter(rs, "display_time_on_mobile_graph", rsColumns, BOOLEAN_CHARACTER_YES);								//		addVOField("display_time_on_mobile_graph", Types.CHAR, "setDisplayTimeOnMobileGraph", Character.class, "getDisplayTimeOnMobileGraph");
        this.disable15Days = getCharacter(rs, "disable_15_days", rsColumns, BOOLEAN_CHARACTER_NO);															//      addVOField("disable_15_days", Types.CHAR, "setDisable15Days", Character.class, "getDisable15Days");
        this.allowEditInformation = getCharacter(rs, "allow_edit_information", rsColumns, BOOLEAN_CHARACTER_NO);
        this.allowDeleteEvents = getCharacter(rs, "allow_delete_events", rsColumns, BOOLEAN_CHARACTER_YES);
        this.allowInsertEvents = getCharacter(rs, "allow_insert_events", rsColumns, BOOLEAN_CHARACTER_YES);
        this.allowEditEvents = getCharacter(rs, "allow_edit_events", rsColumns, BOOLEAN_CHARACTER_YES);
        this.allowDrivingEvents = getCharacter(rs, "allow_driving_events", rsColumns, BOOLEAN_CHARACTER_YES);
        this.collectGPSWithoutTruck = getCharacter(rs, "collect_gps_without_truck", rsColumns, BOOLEAN_CHARACTER_NO);
        this.generateLocationDescription = getString(rs, "generate_location_description", rsColumns, "Manual");														//		addVOField("generate_location_description", Types.VARCHAR, "setGenerateLocationDescription", String.class, "getGenerateLocationDescription");
        this.editsOutOfSync = getDate(rs, "edits_out_of_sync", rsColumns);
        this.inspectionReportOutOfSync = getDate(rs, "inspection_report_out_of_sync", rsColumns);
        this.daySummaryOutOfSync = getDate(rs, "day_summary_out_of_sync", rsColumns);
        this.borderOutOfSync = getDate(rs, "border_out_of_sync", rsColumns);
        this.eldEventsSyncRequested = getCharacter(rs, "eld_events_sync_requested", rsColumns, BOOLEAN_CHARACTER_NO);
        this.eldEventsAutoSync = getCharacter(rs, "eld_events_auto_sync", rsColumns, BOOLEAN_CHARACTER_YES);
        this.showAlertOnNewMessage = getCharacter(rs, "show_alert_on_new_message", rsColumns, BOOLEAN_CHARACTER_NO);
        this.soundNotificationOnNewMessage = getCharacter(rs, "sound_notification_on_new_message", rsColumns, BOOLEAN_CHARACTER_NO);
        this.enableVoiceMessage = getCharacter(rs, "enable_voice_message", rsColumns, BOOLEAN_CHARACTER_NO);
        // this.lastTripId = getLong(rs, "last_trip_id", rsColumns);
        this.legalFirstName = getString(rs, "legal_first_name", rsColumns);
        this.legalLastName = getString(rs, "legal_last_name", rsColumns);
        this.muteViolationSounds = getCharacter(rs, "mute_violation_sounds", rsColumns, BOOLEAN_CHARACTER_NO);
        this.pin = getString(rs, "pin", rsColumns);
        // this.subscriptionId = getLong(rs, "subscription_id", rsColumns);
        this.deviceSequenceOutOfSync = getString(rs, "device_sequence_out_of_sync", rsColumns);
        this.startInspection = getDate(rs, "start_inspection", rsColumns);
        this.updateDate = getDate(rs, "update_date", rsColumns);
        this.onlyUsaDriving = getCharacter(rs, "only_usa_driving", rsColumns, BOOLEAN_CHARACTER_NO);
        // this.dispatchingSystemId = getLong(rs, "dispatching_system_id", rsColumns);
        this.appVersionMsgIntervalMin = getInteger(rs, "app_version_msg_interval_min", rsColumns);
        this.csvSetMilesAndHoursZeroForManualEvents = getCharacter(rs, "csv_set_miles_and_hours_zero_for_manual_events", rsColumns, BOOLEAN_CHARACTER_NO);
        this.maxPersonalUseDistance = getInteger(rs, "max_personal_use_distance", rsColumns);
        this.maxPersonalUseDuration = getInteger(rs, "max_personal_use_duration", rsColumns);
        this.violator = getCharacter(rs, "violator", rsColumns);
        this.violatorComment = getString(rs, "violator_comment", rsColumns);
        this.mobileAppOptions = getString(rs, "mobile_app_options", rsColumns);
        this.masterDBRefId = getLong(rs, "master_db_ref_id", rsColumns);
        this.clientDBRefId = getLong(rs, "client_db_ref_id", rsColumns);
        this.organizationName = getString(rs, "organization_name", rsColumns);
        this.sendLoadOffers = getCharacter(rs, "send_load_offers", rsColumns);
        this.mobileAppOptions = getString(rs, "mobile_app_options", rsColumns);
    }


}
