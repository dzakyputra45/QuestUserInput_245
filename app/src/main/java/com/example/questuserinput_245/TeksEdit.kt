package com.example.questuserinput_245

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormatDataDiri(modifier: Modifier = Modifier) {

    // Input states
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textjk by remember { mutableStateOf("") }


    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    val genderOption = listOf("Laki-laki", "Perempuan")
    val statusOptions = listOf("Janda", "Lajang", "Duda")

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF6F6F6)) // warna lembut abu muda
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
                    .background(Color.Cyan)
                    .padding(vertical = 14.dp),
                textAlign = TextAlign.Center
            )

            OutlinedTextField(
                value = textNama,
                singleLine = true,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.width(250.dp),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = { textNama = it }
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row {
                genderOption.forEach { item ->
                    Row(
                        modifier = Modifier
                            .selectable(
                                selected = textjk == item,
                                onClick = { textjk = item }
                            )
                            .padding(end = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = textjk == item,
                            onClick = { textjk = item }
                        )
                        Text(item)
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = textAlamat,
                singleLine = true,
                modifier = Modifier.width(250.dp),
                label = { Text(text = "Alamat Lengkap") },
                onValueChange = { textAlamat = it }
            )

            HorizontalDivider(
                modifier = Modifier.padding(
                    bottom = dimensionResource(R.dimen.padding_medium),
                    top = dimensionResource(R.dimen.padding_medium)
                ),
                thickness = dimensionResource(R.dimen.padding_tipis),
                color = Color.DarkGray
            )

            Button(
                modifier = Modifier.fillMaxWidth(0.8f),
                enabled = textAlamat.isNotEmpty(),
                onClick = {
                    nama = textNama
                    jenis = textjk
                    alamat = textAlamat
                }
            ) {
                Text(stringResource(R.string.submit))
            }

            HorizontalDivider(
                modifier = Modifier.padding(
                    bottom = dimensionResource(R.dimen.padding_medium),
                    top = dimensionResource(R.dimen.padding_medium)
                ),
                thickness = dimensionResource(R.dimen.padding_tipis),
                color = Color.DarkGray
            )
        }
    }
}

