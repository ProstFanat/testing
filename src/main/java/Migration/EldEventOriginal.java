package Migration;

import DB.RecordMapperValueObject;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Set;

public class EldEventOriginal extends RecordMapperValueObject {
    public static final Character REPLICATION_IS_ENABLED = 'Y';
    public static final Character REPLICATION_IS_DISABLED = 'N';

    private Long eventOriginalId;
    private Character replicable = REPLICATION_IS_ENABLED;

    public EldEventOriginal() {
    }

    public EldEventOriginal(Long eventOriginalId, Character replicable, Long eventId, Long orgId, Date createDate,
                            Long driverId1, Long driverId2, Long truckId, String truckNumber, String trailerNumber, String truckVin,
                            String deviceUid, Integer eventSequence, Integer recordStatus, Integer recordOrigin, Integer eventType,
                            Integer eventCode, String eventDate, String eventTime, String timeZoneOffset, Date eventTimestamp,
                            Long eventTimestampMs, String accumulatedVehicleMiles, String totalVehicleMiles, String elapsedEngineHours,
                            String totalEngineHours, String latitude, String longitude, String latitudeSecondary,
                            String longitudeSecondary, String locationDescription, String distanceSinceLastValidCoords,
                            String malfunctionIndicatorStatus, String dataDiagnosticEventIdicatorStatus, String malfunctionDiagnosticCode,
                            String comment, String dataCheckValue, Date driverCertified, String shippingNumber, String certifiedDate,
                            Date borderCrossingDate, Integer deviceSequence, Date deleteTime, Long eldSequence, String elogAppMode,
                            String deviceType, String appVersion, String country, String provState, String city, Integer eventVersion,
                            Long fuelPurchaseReceiptId, Long remoteEventId, Character isPersonalConveyanceOrYardMove,
                            String totalVehicleMilesEnd, String eldSerialNumber, String platform, Character dataGap){
        new EldEvent(eventId, orgId, createDate, driverId1, driverId2, truckId, truckNumber, trailerNumber, truckVin,
                deviceUid, eventSequence, recordStatus, recordOrigin, eventType, eventCode, eventDate, eventTime,
                timeZoneOffset, eventTimestamp, eventTimestampMs, accumulatedVehicleMiles, totalVehicleMiles,
                elapsedEngineHours, totalEngineHours, latitude, longitude, latitudeSecondary, longitudeSecondary,
                locationDescription, distanceSinceLastValidCoords, malfunctionIndicatorStatus,
                dataDiagnosticEventIdicatorStatus, malfunctionDiagnosticCode, comment, dataCheckValue, driverCertified,
                shippingNumber, certifiedDate, borderCrossingDate, deviceSequence, deleteTime, eldSequence, elogAppMode,
                deviceType, appVersion, country, provState, city, eventVersion, fuelPurchaseReceiptId, remoteEventId,
                isPersonalConveyanceOrYardMove, totalVehicleMilesEnd, eldSerialNumber, platform, dataGap);
        this.eventOriginalId = eventOriginalId;
        this.replicable = replicable;
    }

    public EldEventOriginal(ResultSet rs, Set<String> rsColumns) throws Exception {
        new EldEvent(rs, rsColumns);
        if (rsColumns == null) {
            rsColumns = getRSColumns(rs);
        }
        this.eventOriginalId = getLong(rs, "event_original_id", rsColumns);
        this.replicable = getCharacter(rs, "replicable", rsColumns);
    }

    @Override
    public String toString() {
        return "EldEventOriginal{" +
                "eventOriginalId=" + eventOriginalId +
                ", replicable=" + replicable +
                '}';
    }

    public Long getEventOriginalId() {
        return eventOriginalId;
    }

    public void setEventOriginalId(Long eventOriginalId) {
        this.eventOriginalId = eventOriginalId;
    }

    public Character getReplicable() {
        return replicable;
    }

    public void setReplicable(Character replicable) {
        this.replicable = replicable;
    }



}
