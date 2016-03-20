package kostek.socialheadquarters.config.enums;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by Michal Kostewicz on 20.03.16.
 */
public enum IndexPartitionEnum {
    Y("yyyy"),
    M("yyyyMM"),
    D("yyyyMMdd");

    private DateFormat format;

    IndexPartitionEnum(String wzorzec) {
        this.format = new SimpleDateFormat(wzorzec);
    }

    public DateFormat dajFormat() {
        return format;
    }

    public static IndexPartitionEnum fromValue(String val) {
        IndexPartitionEnum partycjonowanie = null;
        for (IndexPartitionEnum p : IndexPartitionEnum.values()) {
            if (p.name().equals(val)) {
                partycjonowanie = p;
                break;
            }
        }
        return partycjonowanie;
    }
}


