package com.bingwascore.app.ui.community

import com.bingwascore.app.domain.model.OfferType

data class PresetOffer(
    val name: String,
    val ussd: String,
    val price: Int,
    val type: OfferType
)

object OfferPresets {

    val all: List<PresetOffer> = listOf(
        PresetOffer("250Mbs, 24hrs!", "*180*5*2#", 20, OfferType.DATA),
        PresetOffer("750MBs+50SMS, 24Hrs", "*180*5*2#", 55, OfferType.DATA),
        PresetOffer("1GB, 1Hr", "*180*5*2*BH*1*1#", 19, OfferType.DATA),
        PresetOffer("1.5GB, 24Hrs", "*180*5*2#", 99, OfferType.DATA),
        PresetOffer("250MBS, 24Hrs Multiple", "*544*1*1*1*6*BH*3*1#", 24, OfferType.DATA),
        PresetOffer("750Mbs, Multiple", "*544*1*1*1*6*BH*2*1#", 58, OfferType.DATA),
        PresetOffer("1.5GB, 24Hrs - Multiple", "*544*1*1*1*6*BH*1*1#", 102, OfferType.DATA),
        PresetOffer("400MBs, 7Days", "*180*5*2#", 49, OfferType.DATA),
        PresetOffer("20 SMS Daily", "*188#", 5, OfferType.SMS),
        PresetOffer("45Mins - 3Hrs", "*444#", 22, OfferType.MINUTES),
        PresetOffer("50Mins till Midnight", "*444#", 51, OfferType.MINUTES),
        PresetOffer("300Mins Monthly", "*180#", 500, OfferType.MINUTES)
    )
}
