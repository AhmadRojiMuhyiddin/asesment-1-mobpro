
package org.d3if3120.assesment2.data

import android.app.Application
import org.d3if3120.assesment2.db.SuhuDb


class InventoryApplication : Application() {

    val database: SuhuDb by lazy { SuhuDb.getInstance(this) }
}
