package com.webteam.laptopmall.customenum;

public enum EOrderStatus {
    /**
     * The order is pending and has not yet been processed.
     */
    PENDING,

    /**
     * The order is being processed for shipment.
     */
    PROCESSING,

    /**
     * The order has been shipped.
     */
    SHIPPED,

    /**
     * The order has been delivered to the customer.
     */
    DELIVERED,

    /**
     * The order has been cancelled, either by the customer or the seller.
     */
    CANCELLED,

    /**
     * The order has been returned by the customer for various reasons.
     */
    RETURNED,

    /**
     * The payment for the order has been refunded to the customer.
     */
    REFUNDED
}
