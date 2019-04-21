package commands.Helpers;

public class Condition {
        public String field;
        public String value;
        public boolean equal;
        public void setValues(String field, String value, boolean equal) {
            this.field = field;
            this.value = value;
            this.equal = equal;
        }
}
