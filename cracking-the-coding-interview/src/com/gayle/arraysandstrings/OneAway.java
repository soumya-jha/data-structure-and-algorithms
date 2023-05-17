package com.gayle.arraysandstrings;

public class OneAway {
    private boolean checkOneOrZeroEditAway(String s1, String s2) {
        if (s1 == null || s2 == null) {
            return false;
        }
        if (s1.length() == s2.length()) {
            return isOneCharReplaced(s1, s2);
        } else if (Math.abs(s1.length() - s2.length()) == 1) {
            return s1.length() > s2.length() ? isOneCharAdded(s1, s2) : isOneCharAdded(s2, s1);
        }
        return false;
    }

    private boolean isOneCharReplaced(String s1, String s2) {
        int idx = 0;
        boolean found = false;
        while (idx < s1.length()) {
            if (s1.charAt(idx) != s2.charAt(idx)) {
                if (found) {
                    return false;
                }
                found = true;
            }
            idx++;
        }
        return true;
    }

    private boolean isOneCharAdded(String s1, String s2) {
        int p1 = 0, p2 = 0;
        while (p1 < s1.length()) {
            if (s1.charAt(p1) != s2.charAt(p2)) {
                if (p1!=p2) {
                    return false;
                }
                p1++;
            } else {
                p1++;
                p2++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OneAway oneAway = new OneAway();
        System.out.println("Pale, Ple : " + oneAway.checkOneOrZeroEditAway("Pale", "Ple"));
        System.out.println("Ple, Pale : " + oneAway.checkOneOrZeroEditAway("Ple", "Pale"));
        System.out.println("Pale, Ple : " + oneAway.checkOneOrZeroEditAway("Pale", "Pl"));
        System.out.println("Pale, Pale : " + oneAway.checkOneOrZeroEditAway("Pale", "Pale"));
        System.out.println("Pale, Tale : " + oneAway.checkOneOrZeroEditAway("Pale", "Tale"));
        System.out.println("Pale, bae : " + oneAway.checkOneOrZeroEditAway("Pale", "bae"));
        System.out.println("Pale, Tame : " + oneAway.checkOneOrZeroEditAway("Pale", "Tame"));
    }
}