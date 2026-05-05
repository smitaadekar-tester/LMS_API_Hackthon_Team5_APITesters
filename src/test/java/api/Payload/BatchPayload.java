package api.Payload;

import api.Pojo.BatchPojo;
import api.Utilities.CommonUtility;
import api.Utilities.ExcelReader;

import java.util.Map;
import java.util.Random;

public class BatchPayload {

        public static BatchPojo BatchRequest(String sheetname, String Scenario) {

            Map<String, String> data = ExcelReader.getTestData(sheetname, Scenario);
//debug
            System.out.println("Sheet Name: " + sheetname);
            System.out.println("Scenario Name: " + Scenario);
            System.out.println("Excel Data Map: " + data);

            BatchPojo batchPojo = new BatchPojo();

            if (data.get("batchDescription") != null && !data.get("batchDescription").isEmpty()) {
                batchPojo.setBatchDescription(data.get("batchDescription"));
            }

            if (data.get("batchStatus") != null && !data.get("batchStatus").isEmpty()) {
                batchPojo.setBatchStatus(data.get("batchStatus"));
            }

            batchPojo.setProgramId(CommonUtility.programId);
            batchPojo.setProgramName(CommonUtility.programName);

            if (data.get("programId") != null && !data.get("programId").isEmpty()) {
                batchPojo.setProgramId(Integer.parseInt(data.get("programId")));
            }

            if (data.get("programName") != null && !data.get("programName").isEmpty()) {
                batchPojo.setProgramName(data.get("programName"));
            }

            if (Scenario.toLowerCase().contains("duplicate batch name")) {
                batchPojo.setBatchName(CommonUtility.batchName);

            } else if (data.get("batchName") != null && !data.get("batchName").isEmpty()) {
                batchPojo.setBatchName(data.get("batchName"));

            } else {
                batchPojo.setBatchName(generateBatchName(CommonUtility.programName));
            }

            String noOfClasses = data.get("batchNoOfClasses");

            if (noOfClasses != null && !noOfClasses.isEmpty()) {

                if (noOfClasses.matches("\\d+")) { //check if comes as character or number
                    batchPojo.setBatchNoOfClasses(Integer.parseInt(noOfClasses));
                } else {
                    batchPojo.setBatchNoOfClasses(noOfClasses);
                }
            }

            return batchPojo;
        }

        private static String generateBatchName(String programName) {

            Random random = new Random();
            int number = 100 + random.nextInt(900);

            return programName + "_" + number;
        }
    }

