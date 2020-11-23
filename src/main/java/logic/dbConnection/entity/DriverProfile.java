package logic.dbConnection.entity;

public class DriverProfile implements Cloneable{
    private String hosProvider = "";
    private String firstName = "";
    private String lastName = "";
    private String email = "";
    private String phone = "";
    private String status = "";
    private String loginName = "";
    private String password = "";
    private String licenseState = "";
    private String homeTerminalTimezone = "";
    private String driverLicenseNumber = "";
    private String usaMultidayBasis = "";
    private String canadianMultidayBasis = "";
    private String eLogAppMode = "";
    private String eldEditMode = "";
    private String tripStatMinSpeed = "";
    private String tripEndMaxSpeed = "";
    private boolean eldExempt = false;
    private String eldExemptComment = "";
    private boolean driverContractorWithPersonalAuthority = false;
    private String companyName = "";
    private String companyAddress = "";
    private boolean sameAsCompanyAddress = false;
    private String yardAddress = "";
    private String contactInfo = "";
    private String authorityNumbers = "";
    private boolean yardMoveAllowed = false;
    private boolean personalUseAllowed = false;
    private boolean ownerOperator = false;
    private String truckNumber = "";
    private String trailerNumber = "";
    private boolean regainHoursAtMidnight = false;
    private boolean displayTimeOnMobileGraph = false;
    private boolean disable15Days = false;
    private String generateLocationDescription="";
    private boolean allowEditInformation = false;
    private boolean collectGpsWhileNotConnectedToTruck = false;
    private boolean autoSyncEvents = false;
    private boolean showAlertOnNewMessage = false;
    private boolean enableVoiceMessage = false;
    private boolean soundNotificationOnNewMessage = false;
    private boolean allowDeleteEventsInEldApp = false;
    private boolean allowInsertEventsInEldApp = false;
    private boolean allowEditEventsInEldApp = false;
    private boolean allowDrivingEventsInEldApp = false;
    private boolean onlyDrivesInUsa = false;
    private boolean remindDriverToUpdateApp = false;
    private String remindDriverToUpdateAppMinutes = "";
    private boolean forAudit = false;

    public DriverProfile() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public DriverProfile(String hosProvider, String firstName, String lastName, String email,
                         String status, String loginName, String password, String driverLicenseNumber,
                         String licenseState, String homeTerminalTimezone,
                         String usaMultidayBasis, String canadianMultidayBasis, String eLogAppMode) {
        this.hosProvider = hosProvider;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.loginName = loginName;
        this.password = password;
        this.driverLicenseNumber = driverLicenseNumber;
        this.licenseState = licenseState;
        this.homeTerminalTimezone = homeTerminalTimezone;
        this.usaMultidayBasis = usaMultidayBasis;
        this.canadianMultidayBasis = canadianMultidayBasis;
        this.eLogAppMode = eLogAppMode;
    }

    public DriverProfile(String hosProvider, boolean forAudit, String firstName, String lastName, String email, String phone,
                         String status, String loginName, String password, String driverLicenseNumber, String licenseState, String homeTerminalTimezone, String usaMultidayBasis,
                         String canadianMultidayBasis, String eLogAppMode, String tripStatMinSpeed,
                         String tripEndMaxSpeed, boolean eldExempt, String eldExemptComment, boolean driverContractorWithPersonalAuthority,
                         String companyName, String companyAddress, boolean sameAsCompanyAddress, String yardAddress, String contactInfo, String authorityNumbers,
                         boolean yardMoveAllowed, boolean personalUseAllowed, boolean ownerOperator, String truckNumber, String trailerNumber,
                         boolean regainHoursAtMidnight, boolean displayTimeOnMobileGraph, boolean disable15Days, String generateLocationDescription,
                         boolean allowEditInformation, boolean collectGpsWhileNotConnectedToTruck, boolean autoSyncEvents, boolean showAlertOnNewMessage,
                         boolean enableVoiceMessage, boolean soundNotificationOnNewMessage, boolean allowDeleteEventsInEldApp, boolean allowInsertEventsInEldApp,
                         boolean allowEditEventsInEldApp, boolean allowDrivingEventsInEldApp, boolean onlyDrivesInUsa, boolean remindDriverToUpdateApp,
                         String remindDriverToUpdateAppMinutes
    ) {
        this.hosProvider = hosProvider;
        this.forAudit = forAudit;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.status = status;
        this.loginName = loginName;
        this.password = password;
        this.driverLicenseNumber = driverLicenseNumber;
        this.licenseState = licenseState;
        this.homeTerminalTimezone = homeTerminalTimezone;
        this.usaMultidayBasis = usaMultidayBasis;
        this.canadianMultidayBasis = canadianMultidayBasis;
        this.eLogAppMode = eLogAppMode;
        this.tripStatMinSpeed = tripStatMinSpeed;
        this.tripEndMaxSpeed = tripEndMaxSpeed;
        this.eldExempt = eldExempt;
        this.eldExemptComment = eldExemptComment;
        this.driverContractorWithPersonalAuthority = driverContractorWithPersonalAuthority;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.sameAsCompanyAddress = sameAsCompanyAddress;
        this.yardAddress = yardAddress;
        this.contactInfo = contactInfo;
        this.authorityNumbers = authorityNumbers;
        this.yardMoveAllowed = yardMoveAllowed;
        this.personalUseAllowed = personalUseAllowed;
        this.ownerOperator = ownerOperator;
        this.truckNumber = truckNumber;
        this.trailerNumber = trailerNumber;
        this.regainHoursAtMidnight = regainHoursAtMidnight;
        this.displayTimeOnMobileGraph = displayTimeOnMobileGraph;
        this.disable15Days = disable15Days;
        this.generateLocationDescription = generateLocationDescription;
        this.allowEditInformation = allowEditInformation;
        this.collectGpsWhileNotConnectedToTruck = collectGpsWhileNotConnectedToTruck;
        this.autoSyncEvents = autoSyncEvents;
        this.showAlertOnNewMessage = showAlertOnNewMessage;
        this.enableVoiceMessage = enableVoiceMessage;
        this.soundNotificationOnNewMessage = soundNotificationOnNewMessage;
        this.allowDeleteEventsInEldApp = allowDeleteEventsInEldApp;
        this.allowInsertEventsInEldApp = allowInsertEventsInEldApp;
        this.allowEditEventsInEldApp = allowEditEventsInEldApp;
        this.allowDrivingEventsInEldApp = allowDrivingEventsInEldApp;
        this.onlyDrivesInUsa = onlyDrivesInUsa;
        this.remindDriverToUpdateApp = remindDriverToUpdateApp;
        this.remindDriverToUpdateAppMinutes = remindDriverToUpdateAppMinutes;
    }

    public void changeCheckBoxStatus() {
        this.eldExempt = !eldExempt;
        this.driverContractorWithPersonalAuthority = !driverContractorWithPersonalAuthority;
        if(eLogAppMode.equals("ELD")) {
            this.yardMoveAllowed = !yardMoveAllowed;
            this.personalUseAllowed = !personalUseAllowed;
        } else {
            this.yardMoveAllowed=false;
            this.personalUseAllowed=false;
        }
        this.ownerOperator = !ownerOperator;
        this.regainHoursAtMidnight = !regainHoursAtMidnight;
        this.displayTimeOnMobileGraph = !displayTimeOnMobileGraph;
        this.disable15Days = !disable15Days;
        this.allowEditInformation = !allowEditInformation;
        this.collectGpsWhileNotConnectedToTruck = !collectGpsWhileNotConnectedToTruck;
        this.autoSyncEvents = !autoSyncEvents;
        this.showAlertOnNewMessage = !showAlertOnNewMessage;
        this.enableVoiceMessage = !enableVoiceMessage;
        this.soundNotificationOnNewMessage = !soundNotificationOnNewMessage;
        this.allowDeleteEventsInEldApp = !allowDeleteEventsInEldApp;
        this.allowInsertEventsInEldApp = !allowInsertEventsInEldApp;
        this.allowEditEventsInEldApp = !allowEditEventsInEldApp;
        this.allowDrivingEventsInEldApp = !allowDrivingEventsInEldApp;
        //this.onlyDrivesInUsa = !onlyDrivesInUsa;
        this.remindDriverToUpdateApp = !remindDriverToUpdateApp;
        this.forAudit = !forAudit;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public boolean isSameAsCompanyAddress() {
        return sameAsCompanyAddress;
    }

    public void setSameAsCompanyAddress(boolean sameAsCompanyAddress) {
        this.sameAsCompanyAddress = sameAsCompanyAddress;
    }

    public String getYardAddress() {
        return yardAddress;
    }

    public void setYardAddress(String yardAddress) {
        this.yardAddress = yardAddress;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getAuthorityNumbers() {
        return authorityNumbers;
    }

    public void setAuthorityNumbers(String authorityNumbers) {
        this.authorityNumbers = authorityNumbers;
    }

    public boolean isForAudit() {
        return forAudit;
    }

    public void setForAudit(boolean forAudit) {
        this.forAudit = forAudit;
    }

    public String getHosProvider() {
        return hosProvider;
    }

    public void setHosProvider(String hosProvider) {
        this.hosProvider = hosProvider;
    }

    public String getLicenseState() {
        return licenseState;
    }

    public void setLicenseState(String licenseState) {
        this.licenseState = licenseState;
    }

    public String getHomeTerminalTimezone() {
        return homeTerminalTimezone;
    }

    public void setHomeTerminalTimezone(String homeTerminalTimezone) {
        this.homeTerminalTimezone = homeTerminalTimezone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public void setDriverLicenseNumber(String driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public String getUsaMultidayBasis() {
        return usaMultidayBasis;
    }

    public void setUsaMultidayBasis(String usaMultidayBasis) {
        this.usaMultidayBasis = usaMultidayBasis;
    }

    public String getCanadianMultidayBasis() {
        return canadianMultidayBasis;
    }

    public void setCanadianMultidayBasis(String canadianMultidayBasis) {
        this.canadianMultidayBasis = canadianMultidayBasis;
    }

    public String geteLogAppMode() {
        return eLogAppMode;
    }

    public void seteLogAppMode(String eLogAppMode) {
        this.eLogAppMode = eLogAppMode;
    }

    public String getEldEditMode() {
        return eldEditMode;
    }

    public void setEldEditMode(String eldEditMode) {
        this.eldEditMode = eldEditMode;
    }

    public String getTripStatMinSpeed() {
        return tripStatMinSpeed;
    }

    public void setTripStatMinSpeed(String tripStatMinSpeed) {
        this.tripStatMinSpeed = tripStatMinSpeed;
    }

    public String getTripEndMaxSpeed() {
        return tripEndMaxSpeed;
    }

    public void setTripEndMaxSpeed(String tripEndMaxSpeed) {
        this.tripEndMaxSpeed = tripEndMaxSpeed;
    }

    public boolean isEldExempt() {
        return eldExempt;
    }

    public void setEldExempt(boolean eldExempt) {
        this.eldExempt = eldExempt;
    }

    public String getEldExemptComment() {
        return eldExemptComment;
    }

    public void setEldExemptComment(String eldExemptComment) {
        this.eldExemptComment = eldExemptComment;
    }

    public boolean isDriverContractorWithPersonalAuthority() {
        return driverContractorWithPersonalAuthority;
    }

    public void setDriverContractorWithPersonalAuthority(boolean driverContractorWithPersonalAuthority) {
        this.driverContractorWithPersonalAuthority = driverContractorWithPersonalAuthority;
    }

    public boolean isYardMoveAllowed() {
        return yardMoveAllowed;
    }

    public void setYardMoveAllowed(boolean yardMoveAllowed) {
        this.yardMoveAllowed = yardMoveAllowed;
    }

    public boolean isPersonalUseAllowed() {
        return personalUseAllowed;
    }

    public void setPersonalUseAllowed(boolean personalUseAllowed) {
        this.personalUseAllowed = personalUseAllowed;
    }

    public boolean isOwnerOperator() {
        return ownerOperator;
    }

    public void setOwnerOperator(boolean ownerOperator) {
        this.ownerOperator = ownerOperator;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        if (!truckNumber.equals("Select Truck Number..."))
            this.truckNumber = truckNumber;
    }

    public String getTrailerNumber() {
        return trailerNumber;
    }

    public void setTrailerNumber(String trailerNumber) {
        if (!trailerNumber.equals("Select Trailer Number..."))
            this.trailerNumber = trailerNumber;
    }

    public boolean isRegainHoursAtMidnight() {
        return regainHoursAtMidnight;
    }

    public void setRegainHoursAtMidnight(boolean regainHoursAtMidnight) {
        this.regainHoursAtMidnight = regainHoursAtMidnight;
    }

    public boolean isDisplayTimeOnMobileGraph() {
        return displayTimeOnMobileGraph;
    }

    public void setDisplayTimeOnMobileGraph(boolean displayTimeOnMobileGraph) {
        this.displayTimeOnMobileGraph = displayTimeOnMobileGraph;
    }

    public boolean isDisable15Days() {
        return disable15Days;
    }

    public void setDisable15Days(boolean disable15Days) {
        this.disable15Days = disable15Days;
    }

    public String getGenerateLocationDescription() {
        return generateLocationDescription;
    }

    public void setGenerateLocationDescription(String generateLocationDescription) {
        this.generateLocationDescription = generateLocationDescription;
    }

    public boolean isAllowEditInformation() {
        return allowEditInformation;
    }

    public void setAllowEditInformation(boolean allowEditInformation) {
        this.allowEditInformation = allowEditInformation;
    }

    public boolean isCollectGpsWhileNotConnectedToTruck() {
        return collectGpsWhileNotConnectedToTruck;
    }

    public void setCollectGpsWhileNotConnectedToTruck(boolean collectGpsWhileNotConnectedToTruck) {
        this.collectGpsWhileNotConnectedToTruck = collectGpsWhileNotConnectedToTruck;
    }

    public boolean isAutoSyncEvents() {
        return autoSyncEvents;
    }

    public void setAutoSyncEvents(boolean autoSyncEvents) {
        this.autoSyncEvents = autoSyncEvents;
    }

    public boolean isShowAlertOnNewMessage() {
        return showAlertOnNewMessage;
    }

    public void setShowAlertOnNewMessage(boolean showAlertOnNewMessage) {
        this.showAlertOnNewMessage = showAlertOnNewMessage;
    }

    public boolean isEnableVoiceMessage() {
        return enableVoiceMessage;
    }

    public void setEnableVoiceMessage(boolean enableVoiceMessage) {
        this.enableVoiceMessage = enableVoiceMessage;
    }

    public boolean isSoundNotificationOnNewMessage() {
        return soundNotificationOnNewMessage;
    }

    public void setSoundNotificationOnNewMessage(boolean soundNotificationOnNewMessage) {
        this.soundNotificationOnNewMessage = soundNotificationOnNewMessage;
    }

    public boolean isAllowDeleteEventsInEldApp() {
        return allowDeleteEventsInEldApp;
    }

    public void setAllowDeleteEventsInEldApp(boolean allowDeleteEventsInEldApp) {
        this.allowDeleteEventsInEldApp = allowDeleteEventsInEldApp;
    }

    public boolean isAllowInsertEventsInEldApp() {
        return allowInsertEventsInEldApp;
    }

    public void setAllowInsertEventsInEldApp(boolean allowInsertEventsInEldApp) {
        this.allowInsertEventsInEldApp = allowInsertEventsInEldApp;
    }

    public boolean isAllowEditEventsInEldApp() {
        return allowEditEventsInEldApp;
    }

    public void setAllowEditEventsInEldApp(boolean allowEditEventsInEldApp) {
        this.allowEditEventsInEldApp = allowEditEventsInEldApp;
    }

    public boolean isAllowDrivingEventsInEldApp() {
        return allowDrivingEventsInEldApp;
    }

    public void setAllowDrivingEventsInEldApp(boolean allowDrivingEventsInEldApp) {
        this.allowDrivingEventsInEldApp = allowDrivingEventsInEldApp;
    }

    public boolean isOnlyDrivesInUsa() {
        return onlyDrivesInUsa;
    }

    public void setOnlyDrivesInUsa(boolean onlyDrivesInUsa) {
        this.onlyDrivesInUsa = onlyDrivesInUsa;
    }

    public boolean isRemindDriverToUpdateApp() {
        return remindDriverToUpdateApp;
    }

    public void setRemindDriverToUpdateApp(boolean remindDriverToUpdateApp) {
        this.remindDriverToUpdateApp = remindDriverToUpdateApp;
    }

    public String getRemindDriverToUpdateAppMinutes() {
        return remindDriverToUpdateAppMinutes;
    }

    public void setRemindDriverToUpdateAppMinutes(String remindDriverToUpdateAppMinutes) {
        this.remindDriverToUpdateAppMinutes = remindDriverToUpdateAppMinutes;
    }

    @Override
    public String toString() {
        return "DriverProfile {\n" +
                "hosProvider='" + hosProvider + '\'' +
                ",\n firstName='" + firstName + '\'' +
                ",\n lastName='" + lastName + '\'' +
                ",\n email='" + email + '\'' +
                ",\n phone='" + phone + '\'' +
                ",\n status='" + status + '\'' +
                ",\n loginName='" + loginName + '\'' +
                ",\n password='" + password + '\'' +
                ",\n licenseState='" + licenseState + '\'' +
                ",\n homeTerminalTimezone='" + homeTerminalTimezone + '\'' +
                ",\n driverLicenseNumber='" + driverLicenseNumber + '\'' +
                ",\n usaMultidayBasis='" + usaMultidayBasis + '\'' +
                ",\n canadianMultidayBasis='" + canadianMultidayBasis + '\'' +
                ",\n eLogAppMode='" + eLogAppMode + '\'' +
                ",\n eldEditMode='" + eldEditMode + '\'' +
                ",\n tripStatMinSpeed='" + tripStatMinSpeed + '\'' +
                ",\n tripEndMaxSpeed='" + tripEndMaxSpeed + '\'' +
                ",\n eldExempt=" + eldExempt +
                ",\n eldExemptComment='" + eldExemptComment + '\'' +
                ",\n driverContractorWithPersonalAuthority=" + driverContractorWithPersonalAuthority +
                ",\n companyName='" + companyName + '\'' +
                ",\n companyAddress='" + companyAddress + '\'' +
                ",\n sameAsCompanyAddress=" + sameAsCompanyAddress +
                ",\n yardAddress='" + yardAddress + '\'' +
                ",\n contactInfo='" + contactInfo + '\'' +
                ",\n authorityNumbers='" + authorityNumbers + '\'' +
                ",\n yardMoveAllowed=" + yardMoveAllowed +
                ",\n personalUseAllowed=" + personalUseAllowed +
                ",\n ownerOperator=" + ownerOperator +
                ",\n truckNumber='" + truckNumber + '\'' +
                ",\n trailerNumber='" + trailerNumber + '\'' +
                ",\n regainHoursAtMidnight=" + regainHoursAtMidnight +
                ",\n displayTimeOnMobileGraph=" + displayTimeOnMobileGraph +
                ",\n disable15Days=" + disable15Days +
                ",\n generateLocationDescription='" + generateLocationDescription + '\'' +
                ",\n allowEditInformation=" + allowEditInformation +
                ",\n collectGpsWhileNotConnectedToTruck=" + collectGpsWhileNotConnectedToTruck +
                ",\n autoSyncEvents=" + autoSyncEvents +
                ",\n showAlertOnNewMessage=" + showAlertOnNewMessage +
                ",\n enableVoiceMessage=" + enableVoiceMessage +
                ",\n soundNotificationOnNewMessage=" + soundNotificationOnNewMessage +
                ",\n allowDeleteEventsInEldApp=" + allowDeleteEventsInEldApp +
                ",\n allowInsertEventsInEldApp=" + allowInsertEventsInEldApp +
                ",\n allowEditEventsInEldApp=" + allowEditEventsInEldApp +
                ",\n allowDrivingEventsInEldApp=" + allowDrivingEventsInEldApp +
                ",\n onlyDrivesInUsa=" + onlyDrivesInUsa +
                ",\n remindDriverToUpdateApp=" + remindDriverToUpdateApp +
                ",\n remindDriverToUpdateAppMinutes='" + remindDriverToUpdateAppMinutes + '\'' +
                ",\n forAudit=" + forAudit +
                "\n}";
    }
}
