package org.example.java;

import java.util.PriorityQueue;

//    medium. PriorityQueue for non reserved seat
//    https://leetcode.com/problems/seat-reservation-manager
//    Design a system that manages the reservation state of n seats that are numbered from 1 to n.
//    Implement the SeatManager class:
//    SeatManager(int n) Initializes a SeatManager object that will manage n seats numbered from 1 to n. All seats are
//    initially available.
//    int reserve() Fetches the smallest-numbered unreserved seat, reserves it, and returns its number.
//    void unreserve(int seatNumber) Unreserves the seat with the given seatNumber.
//    Example 1:
//    Input
//    ["SeatManager", "reserve", "reserve", "unreserve", "reserve", "reserve", "reserve", "reserve", "unreserve"]
//    [[5], [], [], [2], [], [], [], [], [5]]
//    Output
//    [null, 1, 2, null, 2, 3, 4, 5, null]
//    Explanation
//    SeatManager seatManager = new SeatManager(5); // Initializes a SeatManager with 5 seats.
//    seatManager.reserve();    // All seats are available, so return the lowest numbered seat, which is 1.
//    seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
//    seatManager.unreserve(2); // Unreserve seat 2, so now the available seats are [2,3,4,5].
//    seatManager.reserve();    // The available seats are [2,3,4,5], so return the lowest of them, which is 2.
//    seatManager.reserve();    // The available seats are [3,4,5], so return the lowest of them, which is 3.
//    seatManager.reserve();    // The available seats are [4,5], so return the lowest of them, which is 4.
//    seatManager.reserve();    // The only available seat is seat 5, so return 5.
//    seatManager.unreserve(5); // Unreserve seat 5, so now the available seats are [5].
public class SolutionDay28Sixth {
    private PriorityQueue<Integer> nonReserved;
    int nextSeat;

    public SolutionDay28Sixth(int n) {
        this.nonReserved = new PriorityQueue<>();
        this.nextSeat = 1;
    }

    public int reserve() {
        if (!nonReserved.isEmpty()) {
            return nonReserved.poll();
        }
        int seatNumber = nextSeat;
        nextSeat++;
        return seatNumber;
    }

    public void unreserve(int seatNumber) {
        nonReserved.offer(seatNumber);
    }
/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
}
