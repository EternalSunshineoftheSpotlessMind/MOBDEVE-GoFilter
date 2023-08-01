package com.example.gofilter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kotlin.random.Random

//Component for Home screen / Feed
@Composable
fun ImageCard(
    title: String,
    description: String,
    modifier: Modifier
) {
    Card(
        modifier = Modifier.padding(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        shape = MaterialTheme.shapes.large
    ) {
        //Retrieves photos randomly from picsum
        Image(
            painter = rememberAsyncImagePainter(
                model = "https://picsum.photos/seed/${Random.nextInt()}/300/200"
            ),
            contentDescription = null,
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .fillMaxWidth()
                .aspectRatio(3f / 2f)
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}