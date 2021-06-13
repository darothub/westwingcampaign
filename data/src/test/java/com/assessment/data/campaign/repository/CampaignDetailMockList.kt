package com.assessment.data.campaign.repository

import com.assessment.data.campaign.model.CampaignDetails
import com.assessment.data.campaign.model.CampaignImage

object CampaignDetailMockList {
    fun list()= listOf(
        CampaignDetails(
            "Schlafgut Spannbettlaken",
            "Wenn es um Spannbettlaken geht, sind elastische Stoffe wie dehnbares und formbeständiges " +
                    "Jersey oder Mako-Satin Grundvoraussetzung." +
                    " Denn nur aus diesen Stoffen sitzen die Laken mit Rundum-Gummizug passgenau auf Toppern, " +
                    "Boxspringbetten und herkömmlichen Matratzen in unterschiedlichen Breiten. Von Weiß über Grau bis " +
                    "hin zu Blau – diese eleganten Spannbettlaken " +
                    "sind die Basics für guten Schlaf!",
            "c-schlafgut-spannbettlaken10",
            CampaignImage("https://cdn-ww.westwing.com/image/upload/v1623334165/club/de/campaign/DESPAN12/original_43")

        ),
        CampaignDetails(
            "Keine Chance für Stechmücken",
            "Summende Bienen, zwitschernde Vögel und umherschwirrende Schmetterlinge – " +
                    "das ist Sommer pur! Und was weniger beliebte Summer angeht: " +
                    "Die finden dank Anti-Mücken-Kerzen, Räucherspiralen und Insektenhotels, " +
                    "in denen ihre Feinde hausen, gar nicht erst in Ihre Sommeroase. " +
                    "Super Deal, denn Bienen und Marienkäfer sorgen für Summer Vibes und gleichzeitig dafür, " +
                    "dass die fiesen Stecker fern bleiben. ",
            "c-keine-chance-fuer-stechmuecken",
            CampaignImage("https://cdn-ww.westwing.com/image/upload/v1623334305/club/de/campaign/DESTEC2/original_43")

        ),
        CampaignDetails(
            "Elegante Blütenträume",
            "",
            "c-elegante-bluetentraeume",
            CampaignImage("https://cdn-ww.westwing.com/image/upload/v1623334392/club/de/campaign/DEFLOR16/original_43")

        ),
        CampaignDetails(
            null,
            "Wie das glänzt! Diese Hänge-, Steh- und Tischleuchten ziehen unabhängig " +
                    "vom Stil alle Blicke auf sich. Das liegt am Licht! Denn was die Modelle von schlicht bis" +
                    " glamourös eint, ist die silberne Farbigkeit, die das Licht je nach Material bricht, " +
                    "reflektiert und den eleganten " +
                    "Schimmer so verstärkt. Und die matten, funktionalen Modelle halten sich stilvoll im Hintergrund.",
            "c-leuchten-silber",
            CampaignImage("https://cdn-ww.westwing.com/image/upload/v1623334571/club/de/campaign/DESHIN5/original_43")

        )

    )
}

