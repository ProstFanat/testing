package Migration;

import java.util.ArrayList;
import java.util.List;

public class ACLUserGroup {
    private Long groupId;
    private String userGroup;
    private String description;
    private Long orgId;

    private Long masterDBRefId;

    private List<ACLMatrix> groupResources = new ArrayList<>();

    private List<ACLAssetsInGroup> trailerInGroupList = new ArrayList<>();
    private List<ACLAssetsInGroup> truckInGroupList = new ArrayList<>();
    private List<ACLAssetsInGroup> driverInGroupList = new ArrayList<>();
}
