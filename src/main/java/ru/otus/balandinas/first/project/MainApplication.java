package ru.otus.balandinas.first.project;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class MainApplication {

    public static void main(String[] args) {
        ArrayList<Integer> listInt = new ArrayList<>();

        listInt.add(19);
        listInt.add(5);
        listInt.add(30);
        listInt.add(11);
        listInt.add(39);
        listInt.add(13);
        listInt.add(75);
        listInt.add(1);
        listInt.add(17);
        listInt.add(7);
        listInt.add(12);
        listInt.add(50);
        listInt.add(15);

        StringTree root = new StringTree(listInt.get(0).toString());
        // ярус 1
        StringTree t1L = new StringTree(listInt.get(1).toString());
        StringTree t1R = new StringTree(listInt.get(2).toString());
        root.children = List.of(t1L,t1R);
        // ярус 2
        // лево
        StringTree t2L1 = new StringTree(listInt.get(7).toString());
        StringTree t2R1 = new StringTree(listInt.get(3).toString());
        t1L.children = List.of(t2L1,t2R1);
        // право
        StringTree t2L2 = new StringTree(listInt.get(4).toString());
        t1R.children = List.of(t2L2);
        // ярус 3
        // лево
        StringTree t3R1 = new StringTree(listInt.get(9).toString());
        t2L1.children = List.of(t3R1);
        StringTree t3R2 = new StringTree(listInt.get(5).toString());
        t2R1.children = List.of(t3R2);
        // право
        StringTree t3R3 = new StringTree(listInt.get(6).toString());
        t2L2.children = List.of(t3R3);
        // ярус 4
        // лево
        StringTree t4L1 = new StringTree(listInt.get(10).toString());
        StringTree t4R1 = new StringTree(listInt.get(8).toString());
        t3R2.children = List.of(t4L1,t4R1);
        // право
        StringTree t4R2 = new StringTree(listInt.get(11).toString());
        t3R3.children = List.of(t4R2);
        // заключительный лист
        StringTree t5L1 = new StringTree(listInt.get(12).toString());
        t4R1.children = List.of(t5L1);

        printStructure(root,"");
        root.find(t5L1);
        System.out.println("OK");


    }

    public static void printStructure(StringTree item, String prefix) {
        System.out.println(prefix + "->" + item.getName());
        for (StringTree child: item.getChildren()) {
            printStructure(child, prefix + "->" + item.name);
        }
    }

    public static void treeRightSideFromList(List<Integer> marks, Integer tier, StringTree arr[], int iterator) {
        Integer nextItLeft = null;
        Integer nextItRight = null;
        // tiers
        Integer idxLeftTier = -1;
        Integer idxRightTier = -1;
        // child
        Integer idxLeftChild = -1;
        Integer idxRightChild = -1;

        if (!marks.isEmpty()) {
            arr[iterator] = new StringTree(marks.get(tier).toString());
            //check left tier
            idxLeftTier = leftTierFromList(marks, tier);
            if (idxLeftTier >= 0) {
                nextItLeft = iterator + 1;
                arr[nextItLeft] = new StringTree(marks.get(idxLeftTier).toString());
            } else {
                // left child
                idxLeftChild = leftChildFromList(marks, tier);
                if (idxLeftChild >= 0) {
                    nextItLeft = iterator + 1;
                    arr[nextItLeft] = new StringTree(marks.get(idxLeftChild).toString());
                }
            }

            idxRightTier = rightTierFromList(marks, tier);
            if (idxRightTier >= 0) {
                if (nextItLeft != null) {
                    nextItRight = iterator + 2;
                } else {
                    nextItRight = iterator + 1;
                }
                arr[nextItRight] = new StringTree(marks.get(idxRightTier).toString());
                tier = idxRightTier;
            } else {
                // right child
                if (nextItLeft != null) {
                    nextItRight = iterator + 2;
                } else {
                    nextItRight = iterator + 1;
                }
                idxRightChild = rightChildFromList(marks, tier);
                if (idxRightChild >= 0) {
                    arr[nextItRight] = new StringTree(marks.get(idxRightChild).toString());
                }
            }

            if (nextItLeft != null && nextItRight != null ) {
                arr[iterator].children = List.of(arr[nextItLeft], arr[nextItRight]);
                iterator += 2;
            } else if (nextItLeft != null) {
                arr[iterator].children = List.of(arr[nextItLeft]);
                iterator += 1;
            } else if (nextItRight != null) {
                arr[iterator].children = List.of(arr[nextItRight]);
                iterator += 1;
            }


            if (
                    idxLeftTier == -1 ||
                            idxLeftChild == -1 ||
                            idxRightTier == -1 ||
                            idxRightChild == -1

            ) {
                treeRightSideFromList(marks, tier, arr, iterator);
            }

        }
    }

    public static Integer idxLeftFromList(List<Integer> marks, int tier) {
        Integer elnum = -1;
        if (!marks.isEmpty()) {
            for (Integer mark : marks) {
                if (mark < tier) {
                    elnum = marks.indexOf(mark);
                } else {
                    return elnum;
                }
            }
        }
        return elnum;
    }

    public static Integer idxRightFromList(List<Integer> marks, int tier) {
        Integer elnum = -1;
        if (!marks.isEmpty()) {
            for (Integer mark : marks) {
                if (mark > tier) {
                    elnum = marks.indexOf(mark);
                    break;
                }
            }
        }
        return elnum;
    }

    public static Integer leftChildFromList(List<Integer> marks, int tier) {
        Integer lastItem = -1;
        if (!marks.isEmpty()) {
            for (Integer mark : marks) {
                if (mark == tier) {
                    break;
                } else {
                    lastItem = marks.indexOf(mark);
                }
            }
        }
        return lastItem;
    }

    public static Integer leftTierFromList(List<Integer> marks, int tier) {
        Integer elnum = -1;
        if (!marks.isEmpty()) {
            if (tier == (marks.size() / 2)) {
                elnum = tier - 2;
            } else {
                elnum = tier - 3;
            }
        }
        if (elnum < 0) {
            elnum = -1;
        }

        return elnum;
    }

    public static Integer rightChildFromList(List<Integer> marks, int tier) {
        if (!marks.isEmpty()) {
            for (Integer mark : marks) {
                if (mark > tier) {
                    return marks.indexOf(mark);
                }
            }
        }
        return -1;
    }

    public static Integer rightTierFromList(List<Integer> marks, int tier) {
        Integer elnum = -1;
        if (!marks.isEmpty()) {

            if (tier == (marks.size() / 2)) {
                elnum = tier + 2;
            } else {
                elnum = tier + 3;
            }

        }
        if (elnum < 0) {
            elnum = -1;
        }
        return elnum;
    }

    public static Integer idxRightTierFromList(List<Integer> marks, int tier) {
        Integer elnum = -1;
        if (!marks.isEmpty()) {
            try {
                if (tier == (marks.size() / 2)) {
                    elnum = marks.get(tier + 2);
                } else {
                    elnum = marks.get(tier + 3);
                }
            } catch (Exception e) {
            }
        }
        return elnum;
    }

    public static Integer idxLeftTierFromList(List<Integer> marks, int tier) {
        Integer elnum = -1;
        if (!marks.isEmpty()) {
            try {
                if (tier == (marks.size() / 2)) {
                    elnum = marks.get(tier - 2);
                } else {
                    elnum = marks.get(tier - 3);
                }
            } catch (Exception e) {
            }
        }
        return elnum;
    }

}
