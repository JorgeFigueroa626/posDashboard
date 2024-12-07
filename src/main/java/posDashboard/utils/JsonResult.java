package posDashboard.utils;

import lombok.Data;

@Data
public class JsonResult {

    private boolean result;
    private Object data;
    private String response;
}
