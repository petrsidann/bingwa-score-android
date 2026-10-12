package com.bingwascore.app.ui.diplomatics

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.PushPin
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.bingwascore.app.data.preferences.UserPreferences
import com.bingwascore.app.ui.home.Greetings
import com.bingwascore.app.ui.theme.AccentBlue
import com.bingwascore.app.ui.theme.BgBlack
import com.bingwascore.app.ui.theme.Hairline
import com.bingwascore.app.ui.theme.IOS_CARD_RADIUS
import com.bingwascore.app.ui.theme.Raised
import com.bingwascore.app.ui.theme.TextDim
import com.bingwascore.app.ui.theme.TextGrey
import com.bingwascore.app.ui.theme.TextWhite
import com.bingwascore.app.util.rememberHaptics
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Stage 12 — the state behind [DiplomaticsScreen].
 *
 * Pin / keep-rotating and the cadence live in DataStore, so the choice survives
 * the session it was made in. The current language is computed with the SAME
 * pure rule the Home greeting uses ([Greetings.languageFor]), keyed by the
 * persisted session index, so the screen can never disagree with the line.
 */
@HiltViewModel
class DiplomaticsViewModel @Inject constructor(
    private val userPreferences: UserPreferences
) : ViewModel() {

    /** Pinned language as Language.name; "" = keep rotating. */
    val pinnedLanguage: StateFlow<String> = userPreferences.greetingPinnedLanguage
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), "")

    val cadence: StateFlow<Greetings.Cadence> = userPreferences.greetingCadence
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), Greetings.Cadence.SESSION)

    /** What the Home greeting is showing right now — same rule, same inputs. */
    val currentLanguage: StateFlow<Greetings.Language> =
        combine(pinnedLanguage, cadence) { pinned, cadence ->
            val session = runCatching { userPreferences.greetingSession.first() }.getOrDefault(0)
            Greetings.languageFor(
                dayOfYear = Greetings.todayIndex(),
                sessionIndex = session,
                cadence = cadence,
                pinned = pinned.ifBlank { null }?.let { raw ->
                    Greetings.Language.entries.firstOrNull { it.name == raw }
                }
            )
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), Greetings.Language.SWAHILI)

    fun keepRotating() {
        viewModelScope.launch { userPreferences.setGreetingPinnedLanguage("") }
    }

    fun pinLanguage(language: Greetings.Language) {
        viewModelScope.launch { userPreferences.setGreetingPinnedLanguage(language.name) }
    }

    fun setCadence(value: Greetings.Cadence) {
        viewModelScope.launch { userPreferences.setGreetingCadence(value) }
    }
}

/**
 * Stage 12 — Diplomatics: the greeting language, on purpose.
 *
 * Eight languages, each in its own words with a sample line, a choice between
 * keeping the rotation and pinning one, and a cadence (per session or per day).
 * The current language wears the check; a pinned one wears the pin.
 */
@Composable
fun DiplomaticsScreen(viewModel: DiplomaticsViewModel = hiltViewModel()) {
    val haptics = rememberHaptics()
    val pinned by viewModel.pinnedLanguage.collectAsStateWithLifecycle()
    val cadence by viewModel.cadence.collectAsStateWithLifecycle()
    val current by viewModel.currentLanguage.collectAsStateWithLifecycle()
    val isRotating = pinned.isBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BgBlack)
            .padding(horizontal = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Diplomatics",
            color = TextWhite,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "The greeting meets you in a language on purpose.",
            color = TextGrey,
            fontSize = 13.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        // ── Current language indicator ────────────────────────────────────
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(IOS_CARD_RADIUS))
                .background(Raised)
                .border(1.dp, Hairline, RoundedCornerShape(IOS_CARD_RADIUS))
                .padding(14.dp)
        ) {
            Icon(
                imageVector = Icons.Rounded.PushPin,
                contentDescription = null,
                tint = AccentBlue,
                modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(text = "Now greeting in", color = TextGrey, fontSize = 11.sp)
                Text(
                    text = "${current.endonym} · " + Greetings.text(Greetings.Bucket.MORNING, current),
                    color = TextWhite,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // ── Keep rotating vs pin one ──────────────────────────────────────
        Text(text = "ROTATION", color = TextDim, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(6.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(IOS_CARD_RADIUS))
                .background(Raised)
                .border(1.dp, Hairline, RoundedCornerShape(IOS_CARD_RADIUS))
        ) {
            SegmentCell(
                label = "Keep rotating",
                selected = isRotating,
                modifier = Modifier.weight(1f),
                onClick = { haptics.tick(); viewModel.keepRotating() }
            )
            SegmentCell(
                label = "Pin one language",
                selected = !isRotating,
                modifier = Modifier.weight(1f),
                onClick = { haptics.tick(); viewModel.pinLanguage(current) }
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        // ── Cadence ───────────────────────────────────────────────────────
        Text(text = "CADENCE", color = TextDim, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
        Spacer(modifier = Modifier.height(6.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(IOS_CARD_RADIUS))
                .background(Raised)
                .border(1.dp, Hairline, RoundedCornerShape(IOS_CARD_RADIUS))
        ) {
            SegmentCell(
                label = "Per session",
                selected = cadence == Greetings.Cadence.SESSION,
                modifier = Modifier.weight(1f),
                onClick = { haptics.tick(); viewModel.setCadence(Greetings.Cadence.SESSION) }
            )
            SegmentCell(
                label = "Per day",
                selected = cadence == Greetings.Cadence.DAY,
                modifier = Modifier.weight(1f),
                onClick = { haptics.tick(); viewModel.setCadence(Greetings.Cadence.DAY) }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))
        LanguageList(
            pinned = pinned,
            current = current,
            onPin = { language -> haptics.tick(); viewModel.pinLanguage(language) }
        )
    }
}

/** The eight languages, each in its own words with a sample greeting. */
@Composable
private fun LanguageList(
    pinned: String,
    current: Greetings.Language,
    onPin: (Greetings.Language) -> Unit
) {
    Text(text = "THE EIGHT", color = TextDim, fontSize = 11.sp, fontWeight = FontWeight.SemiBold)
    Spacer(modifier = Modifier.height(6.dp))
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(Greetings.Language.entries, key = { it.name }) { language ->
            val sample = Greetings.text(Greetings.Bucket.MORNING, language)
            val isCurrent = language == current
            val isPinned = language.name == pinned
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(IOS_CARD_RADIUS))
                    .background(Raised)
                    .border(
                        1.dp,
                        if (isCurrent) AccentBlue.copy(alpha = 0.45f) else Hairline,
                        RoundedCornerShape(IOS_CARD_RADIUS)
                    )
                    .clickable { onPin(language) }
                    .padding(horizontal = 14.dp, vertical = 12.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = language.endonym,
                        color = TextWhite,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = sample,
                        color = TextGrey,
                        fontSize = 12.sp,
                        fontStyle = FontStyle.Italic,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                if (isPinned) {
                    Icon(
                        imageVector = Icons.Rounded.PushPin,
                        contentDescription = "Pinned",
                        tint = AccentBlue,
                        modifier = Modifier.size(14.dp)
                    )
                } else if (isCurrent) {
                    Icon(
                        imageVector = Icons.Rounded.CheckCircle,
                        contentDescription = "Current",
                        tint = AccentBlue,
                        modifier = Modifier.size(14.dp)
                    )
                }
            }
        }
    }
}

/** One cell of an iOS-style segmented control. */
@Composable
private fun SegmentCell(
    label: String,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .background(if (selected) AccentBlue.copy(alpha = 0.16f) else Color.Transparent)
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp)
    ) {
        Text(
            text = label,
            color = if (selected) AccentBlue else TextGrey,
            fontSize = 13.sp,
            fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Normal
        )
    }
}