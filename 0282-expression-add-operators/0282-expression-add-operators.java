class Solution {
    List<String> ans = new ArrayList<>();
    public void solve(String num, int index, String expression, long value, long previous, int target) {
        // We have used the entire string
        if(index == num.length()) {
            if(value == target) {
                ans.add(expression);
            }
            return;
        }
        // Try taking 1 digit, 2 digits, 3 digits...
        for(int i = index; i < num.length(); i++) {
            // Don't allow numbers like 05, 006, etc.
            if(i > index && num.charAt(index) == '0') {
                break;
            }
            String part = num.substring(index, i + 1);
            long current = Long.parseLong(part);
            // First number
            if(index == 0) {
                solve(num, i + 1, part, current, current, target);
            } else {
                // +
                solve(num, i + 1, expression + "+" + part, value + current, current, target);
                // -
                solve(num, i + 1, expression + "-" + part, value - current, -current, target);
                // *
                solve(num, i + 1, expression + "*" + part, value - previous + previous * current, previous * current, target);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        solve(num, 0, "", 0, 0, target);
        return ans;
    }
}