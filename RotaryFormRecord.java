/*
   *************************************************************************************************
   Program: RotaryFormRecord.java
   Repository Name: Rotary-Form
   Date Created: 03-Jul-19
   Program Description: This class is extends the PestProblem class and contains all the
   necessary data required in a record on the form.
   
   *************************************************************************************************
*/

import java.lang.reflect.*;
import java.util.stream.Stream;

public class RotaryFormRecord extends PestProblem {
    public static final int[] STRING_FIELDS = {1, 2, 3, 5, 6, 7};
    private String unitAddress;
    private String keyHome;
    private boolean followup;
    private String pestLevel;
    private String houseKeeping;
    private String comments;

    public RotaryFormRecord() {

    }

    public RotaryFormRecord(String unitAddress, String keyHome, String pestLevel,
                            String houseKeeping) {
        setUnitAddress(unitAddress);
        setKeyHome(keyHome);
        setPestLevel(pestLevel);
        setHouseKeeping(houseKeeping);
    }

    public String getUnitAddress() {
        return unitAddress;
    }

    public int setUnitAddress(String unitAddress) {
        if (!unitAddress.isEmpty()) {
            this.unitAddress = unitAddress;
            return 1;
        }
        System.out.println("Please enter valid unit address.");
        return -1;
    }

    public String getKeyHome() {
        return keyHome;
    }

    public int setKeyHome(String keyHome) {
        if (keyHome.equalsIgnoreCase("key") || keyHome.equalsIgnoreCase("home")) {
            this.keyHome = keyHome;
            return 1;
        }
        System.out.println("Please enter key or home.");
        return -1;
    }

    public boolean isFollowup() {
        return followup;
    }

    public void setFollowup(boolean followup) {
        this.followup = followup;
    }

    public String getPestLevel() {
        return pestLevel;
    }

    public int setPestLevel(String pestLevel) {
        if (Stream.of("low", "medium", "high").anyMatch(pestLevel::equalsIgnoreCase)) {
            this.pestLevel = pestLevel;
            return 1;
        }
        System.out.println("Please enter low, medium or high");
        return -1;
    }

    public String getHouseKeeping() {
        return houseKeeping;
    }

    public int setHouseKeeping(String houseKeeping) {
        if (!houseKeeping.isEmpty()) {
            this.houseKeeping = houseKeeping;
            return 1;
        }
        System.out.println("Please enter valid response.");
        return -1;

    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void fill(int field, String data) {
        boolean check = true;
        for (int n : STRING_FIELDS
        ) {
            check = n == field;
            if (!check) {
                break;
            }
        }

        if (check) {
            switch (field) {
                case 1:
                    setUnitAddress(data);
                case 2:
                    setOthers(data);
                case 3:
                    setKeyHome(data);
                case 5:
                    setPestLevel(data);
                case 6:
                    setHouseKeeping(data);
                case 7:
                    setComments(data);
            }
        }
    }

    public void fill(int field, boolean bool) {
        if (field == 4) {
            setFollowup(bool);
        }
    }

    public String toString(Object o) throws Exception {
        if (o instanceof RotaryFormRecord) {
            StringBuilder str = new StringBuilder();

            for (Field field : getClass().getDeclaredFields()
            ) {
                String value = null;
                if (!field.getName().equals("STRING_FIELDS")) {
                    StringBuilder getter = new StringBuilder();
                    if (field.getName().equals("followup")) {
                        getter.append("is");
                    } else {
                        getter.append("get");
                    }
                    getter.append(field.getName().substring(0, 1).toUpperCase());
                    getter.append(field.getName().substring(1));
                    try {
                        Method method = getClass().getDeclaredMethod(getter.toString());
                        value = String.valueOf(method.invoke(o));
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                    str.append(value);
                    str.append(",");
                }
            }
            str.append(toString());
            return str.toString();
        }
        throw new Exception("Invalid object type as input parameter");
    }
}
