package fr.upjv.myapplication.ui.model

import fr.upjv.myapplication.data.model.ChuckNorrisEntity

data class ChuckNorrisObject(
    val title: String,
    val url: String,
)


fun List<ChuckNorrisEntity>.toUi(): List<ChuckNorrisObject> {
    return map { eachEntity ->
        ChuckNorrisObject(
            title = eachEntity.quote,
            url = eachEntity.iconUrl,
        )
    }
}
