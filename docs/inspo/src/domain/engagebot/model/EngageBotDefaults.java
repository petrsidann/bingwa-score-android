package com.example.bingwahybrid.domain.engagebot.model;

import kotlin.Metadata;

/* JADX INFO: compiled from: EngageBotDefaults.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/example/bingwahybrid/domain/engagebot/model/EngageBotDefaults;", "", "<init>", "()V", "ENGAGE_MESSAGE", "", "SUCCESS_RESPONSE", "INVALID_INPUT_RESPONSE", "SESSION_TIMEOUT_RESPONSE", "SESSION_TIMEOUT_MINS", "", "app_debug"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class EngageBotDefaults {
    public static final int $stable = 0;
    public static final String ENGAGE_MESSAGE = "You have already purchased a Bingwa Offer today. Please reply with an alternative Safaricom number to recommend instead";
    public static final EngageBotDefaults INSTANCE = new EngageBotDefaults();
    public static final String INVALID_INPUT_RESPONSE = "Invalid input. Please try again";
    public static final int SESSION_TIMEOUT_MINS = 10;
    public static final String SESSION_TIMEOUT_RESPONSE = "Session Auto-Closed. Thank you for using Bingwa Sokoni";
    public static final String SUCCESS_RESPONSE = "Thank you. Recommending offer to { @first_name - }@phone instead";

    private EngageBotDefaults() {
    }
}
