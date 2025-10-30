package com.example.questuserinput_245

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun FormatDataDiri(modifier: Modifier = Modifier) {

    // Input states
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember { mutableStateOf("") }
    var textjk by remember { mutableStateOf("") }

    // Output states
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    val gender = listOf("Laki-laki", "Perempuan")


    Column(
        modifier = modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

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
            gender.forEach { item ->
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
    }


    }

