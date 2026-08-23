package com.bingwascore.app.ui.admin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.bingwascore.app.domain.model.Bundle
import com.bingwascore.app.ui.components.BingwaButton
import com.bingwascore.app.ui.components.BingwaTextField
import com.bingwascore.app.ui.components.Skeleton
import com.bingwascore.app.ui.theme.Emerald500
import com.bingwascore.app.ui.theme.Rose500

@Composable
fun AdminBundlesTab(state: AdminState, viewModel: AdminViewModel) {
    var deleteTarget by remember { mutableStateOf<Bundle?>(null) }

    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    "Bundle catalogue",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    "${state.bundles.size} bundles",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primary)
                    .clickable { viewModel.showBundleForm() }
                    .padding(12.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add", tint = androidx.compose.ui.graphics.Color.White)
            }
        }

        if (state.isBundleFormVisible) {
            BundleFormCard(
                editing = state.editingBundle,
                onSave = { type, name, size, validity, cost, sale ->
                    viewModel.saveBundle(type, name, size, validity, cost, sale)
                },
                onCancel = { viewModel.hideBundleForm() }
            )
        }

        if (state.isLoading && state.bundles.isEmpty()) {
            repeat(3) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .clip(RoundedCornerShape(20.dp))
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(16.dp)
                ) {
                    Column {
                        Skeleton(height = 18.dp, modifier = Modifier.width(180.dp))
                        Spacer(Modifier.height(8.dp))
                        Skeleton(height = 14.dp, modifier = Modifier.width(120.dp))
                    }
                }
            }
        } else {
            state.bundles.forEach { bundle ->
                BundleRow(
                    bundle = bundle,
                    onEdit = { viewModel.showBundleForm(bundle) },
                    onDelete = { deleteTarget = bundle },
                    onToggleActive = { viewModel.toggleBundleActive(bundle) }
                )
            }
        }
    }

    deleteTarget?.let { bundle ->
        AlertDialog(
            onDismissRequest = { deleteTarget = null },
            title = { Text("Delete bundle?") },
            text = { Text("This will permanently remove \"${bundle.name}\".") },
            confirmButton = {
                TextButton(onClick = {
                    viewModel.deleteBundle(bundle.id)
                    deleteTarget = null
                }) {
                    Text("Delete", color = Rose500, fontWeight = FontWeight.Bold)
                }
            },
            dismissButton = {
                TextButton(onClick = { deleteTarget = null }) {
                    Text("Cancel")
                }
            }
        )
    }
}

@Composable
private fun BundleRow(
    bundle: Bundle,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    onToggleActive: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        bundle.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.width(8.dp))
                    Box(
                        modifier = Modifier
                            .background(
                                MaterialTheme.colorScheme.surfaceVariant,
                                RoundedCornerShape(100.dp)
                            )
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    ) {
                        Text(
                            bundle.type.uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Spacer(Modifier.height(4.dp))
                Row {
                    Text(
                        bundle.size,
                        style = MaterialTheme.typography.bodySmall,
                        fontFamily = FontFamily.Monospace,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Text(
                        " · ${bundle.validity}",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Spacer(Modifier.height(6.dp))
                Row {
                    Text(
                        "Cost: KES ${bundle.costPrice.toInt()}",
                        style = MaterialTheme.typography.labelSmall,
                        fontFamily = FontFamily.Monospace,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(Modifier.width(12.dp))
                    Text(
                        "Sale: KES ${bundle.salePrice.toInt()}",
                        style = MaterialTheme.typography.labelSmall,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(Modifier.width(12.dp))
                    Text(
                        "+KES ${(bundle.salePrice - bundle.costPrice).toInt()}",
                        style = MaterialTheme.typography.labelSmall,
                        fontFamily = FontFamily.Monospace,
                        color = Emerald500,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
            Column(horizontalAlignment = Alignment.End) {
                Row {
                    IconButton(onClick = onEdit, modifier = Modifier.size(36.dp)) {
                        Icon(Icons.Default.Edit, contentDescription = "Edit", tint = MaterialTheme.colorScheme.primary)
                    }
                    IconButton(onClick = onDelete, modifier = Modifier.size(36.dp)) {
                        Icon(Icons.Default.Delete, contentDescription = "Delete", tint = Rose500)
                    }
                }
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100.dp))
                        .background(
                            if (bundle.active) Emerald500.copy(alpha = 0.15f)
                            else MaterialTheme.colorScheme.surfaceVariant
                        )
                        .clickable { onToggleActive() }
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        if (bundle.active) "Active" else "Inactive",
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = if (bundle.active) Emerald500
                        else MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}

@Composable
private fun BundleFormCard(
    editing: Bundle?,
    onSave: (String, String, String, String, Double, Double) -> Unit,
    onCancel: () -> Unit
) {
    var type by remember { mutableStateOf(editing?.type ?: "data") }
    var name by remember { mutableStateOf(editing?.name ?: "") }
    var size by remember { mutableStateOf(editing?.size ?: "") }
    var validity by remember { mutableStateOf(editing?.validity ?: "") }
    var cost by remember { mutableStateOf(editing?.costPrice?.toString() ?: "") }
    var sale by remember { mutableStateOf(editing?.salePrice?.toString() ?: "") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(20.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text(
                if (editing != null) "Edit bundle" else "New bundle",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                listOf("data", "minutes", "sms").forEach { t ->
                    val isActive = type == t
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clip(RoundedCornerShape(12.dp))
                            .background(
                                if (isActive) MaterialTheme.colorScheme.primary
                                else MaterialTheme.colorScheme.surfaceVariant
                            )
                            .clickable { type = t }
                            .padding(vertical = 10.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            t.replaceFirstChar { it.uppercase() },
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.SemiBold,
                            color = if (isActive)
                                androidx.compose.ui.graphics.Color.White
                            else
                                MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

            BingwaTextField(value = name, onValueChange = { name = it }, label = "Name", placeholder = "500MB Daily")
            BingwaTextField(value = size, onValueChange = { size = it }, label = "Size", placeholder = "500MB", isMono = true)
            BingwaTextField(value = validity, onValueChange = { validity = it }, label = "Validity", placeholder = "1 day")

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                BingwaTextField(
                    value = cost,
                    onValueChange = { cost = it.filter { c -> c.isDigit() || c == '.' } },
                    label = "Cost (KES)",
                    isMono = true,
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier.weight(1f)
                )
                BingwaTextField(
                    value = sale,
                    onValueChange = { sale = it.filter { c -> c.isDigit() || c == '.' } },
                    label = "Sale (KES)",
                    isMono = true,
                    keyboardType = KeyboardType.Number,
                    modifier = Modifier.weight(1f)
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                BingwaButton(
                    text = if (editing != null) "Update" else "Create",
                    onClick = {
                        val costNum = cost.toDoubleOrNull() ?: 0.0
                        val saleNum = sale.toDoubleOrNull() ?: 0.0
                        if (name.isNotBlank() && size.isNotBlank() && validity.isNotBlank() && saleNum > costNum) {
                            onSave(type, name, size, validity, costNum, saleNum)
                        }
                    },
                    enabled = name.isNotBlank() && size.isNotBlank() && validity.isNotBlank() &&
                            (cost.toDoubleOrNull() ?: 0.0) >= 0 &&
                            (sale.toDoubleOrNull() ?: 0.0) > (cost.toDoubleOrNull() ?: 0.0),
                    modifier = Modifier.weight(1f)
                )
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .clickable { onCancel() },
                    contentAlignment = Alignment.Center
                ) {
                    Text("Cancel", fontWeight = FontWeight.SemiBold)
                }
            }
        }
    }
}
