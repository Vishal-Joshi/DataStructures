package com.example;

public class GeeksForGeeksSearchInSortedArray {

    /* Searches an element key in a
       pivoted sorted array arrp[]
       of size n */
    static int pivotedBinarySearch(int arr[], int n, int key) {
        int pivot = findPivot(arr, 0, n - 1);

        // If we didn't find a pivot, then
        // array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, n - 1, key);

        // If we found a pivot, then first
        // compare with pivot and then
        // search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot - 1, key);
        return binarySearch(arr, pivot + 1, n - 1, key);
    }

    /* Function to get pivot. For array
       3, 4, 5, 6, 1, 2 it returns
       3 (index of 6) */
    static int findPivot(int arr[], int low, int high) {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

       /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }

    /* Standard Binary Search function */
    static int binarySearch(int arr[], int low, int high, int key) {
        if (high < low)
            return -1;

       /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }

    // main function
    public static void main(String args[]) {
        // Let us search 3 in below array
        String[] arrayAsString = "39 51 71 84 92 93 149 154 158 173 178 193 216 217 231 243 410 425 429 459 476 482 483 540 542 567 586 587 593 746 807 823 833 839 850 873 919 923 975 1000 994 992 990 989 987 984 980 979 976 970 965 960 958 955 945 939 928 915 910 909 905 896 889 885 879 874 872 870 862 861 852 846 841 838 829 828 826 825 821 820 819 817 816 815 814 812 811 804 803 801 800 790 784 783 780 778 774 765 764 763 761 758 756 753 750 738 733 728 725 724 716 712 711 708 705 704 701 699 697 686 685 684 683 682 680 673 670 666 663 658 650 648 645 643 640 639 634 626 615 613 603 594 592 588 584 583 582 580 579 569 565 560 559 558 557 555 547 541 539 538 534 533 532 526 520 510 509 508 505 498 488 487 485 481 475 474 472 470 464 460 456 452 451 447 446 443 441 439 432 430 427 424 415 409 408 401 398 394 393 388 386 381 380 379 376 370 367 366 362 358 357 355 354 349 348 342 337 333 331 330 324 320 318 316 312 308 306 305 304 302 301 296 291 280 273 271 270 269 263 259 258 255 246 242 239 236 228 224 223 222 221 220 213 208 207 205 203 202 196 191 190 187 185 184 180 170 169 161 160 155 150 147 141 137 135 132 130 129 122 121 117 116 107 102 96 95 94 90 89 86 81 79 78 77 73 67 61 59 56 52 49 38 27 23 19 14 12 11 4".split(" ");
        int arr1[] = new int[arrayAsString.length];
        for (int i = 0; i < arrayAsString.length; i++) {
            arr1[i] = Integer.parseInt(arrayAsString[i]);
        }

        int n = arr1.length;
        int key = 862;
        System.out.println("Index of the element is : "
                + pivotedBinarySearch(arr1, n, key));
    }
}
