package api.Payload;

import api.Pojo.ProgramPojo;
import api.Utilities.CommonUtility;
import api.Utilities.ExcelReader;

import java.util.Map;

public class ProgramPayload {
    public static ProgramPojo ProgRequest(String sheetname, String Scenario) {

        Map<String, String> data = ExcelReader.getTestData(sheetname ,Scenario);
//debug
        System.out.println("Sheet Name: " + sheetname);
        System.out.println("Scenario Name: " + Scenario);
        System.out.println("Excel Data Map: " + data);

        ProgramPojo programPojo = new ProgramPojo();
        if (data.get("programName") != null && !data.get("programName").isEmpty()) {
            programPojo.setProgramName(data.get("programName"));
        }

        if (data.get("programDescription") != null && !data.get("programDescription").isEmpty()) {
            programPojo.setProgramDescription(data.get("programDescription"));
        }

        if (data.get("programStatus") != null && !data.get("programStatus").isEmpty()) {
            programPojo.setProgramStatus(data.get("programStatus"));
        }
        return programPojo;
    }
}
