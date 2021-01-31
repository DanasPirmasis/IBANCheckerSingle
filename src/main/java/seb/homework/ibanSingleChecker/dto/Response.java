package seb.homework.ibanSingleChecker.dto;

public class Response {
    private String content;
    private boolean isValid;
    private boolean belongToSEB;

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public boolean getIsValid() {
        return isValid;
    }
    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }

    public boolean getBelongToSEB() {
        return belongToSEB;
    }
    public void setBelongToSEB(boolean belongToSEB) {
        this.belongToSEB = belongToSEB;
    }
}
