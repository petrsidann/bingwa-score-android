package com.bingwascore.app.domain

/**
 * Parity F — pipeline guards.
 *
 * These are the "loud" exits of the money path: instead of silently swallowing
 * a rule violation the engine throws a typed exception, the caller catches it
 * and turns it into a *visible, side-effect-free* outcome (an IGNORED audit row
 * with zero replies, or red text in the offer sheet). Nothing here touches
 * Room, Android or the network, so both guards are unit-testable pure JVM.
 */

/**
 * Thrown when an M-Pesa SMS arrives from a sender that is not in the
 * authorized-senders list (only when that list is non-empty — an empty list
 * means "trust everyone", the default-open behaviour).
 *
 * The pipeline catches this and records a transaction with
 * [TransactionStatus.IGNORED] — no USSD dial, no auto-reply.
 */
class InvalidSenderException(val sender: String) :
    Exception("Sender '$sender' is not in the authorized-senders list")

/**
 * Thrown when the offer actions sheet tries to save a fallback dial rule for a
 * (fromStatus, toOfferId) pair that already exists. The sheet surfaces
 * [message] as red error text instead of silently overwriting the rule.
 */
class DuplicateOfferTransitionRuleException(val from: String, val to: String) :
    Exception("A fallback rule for $from to $to already exists")
