package com.dicoding.projecttest.data

import com.google.gson.annotations.SerializedName

data class InvoiceResponse(

	@field:SerializedName("data")
	val data: Data3? = null,

	@field:SerializedName("meta")
	val meta: Meta3? = null
)

data class TrxSalesInvoiceItemsItem(

	@field:SerializedName("item_code")
	val itemCode: String? = null,

	@field:SerializedName("item_sub_total")
	val itemSubTotal: String? = null,

	@field:SerializedName("item_total_price")
	val itemTotalPrice: String? = null,

	@field:SerializedName("si_code")
	val siCode: String? = null,

	@field:SerializedName("item_price")
	val itemPrice: String? = null,

	@field:SerializedName("item_disc_value")
	val itemDiscValue: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("item_notes")
	val itemNotes: Any? = null,

	@field:SerializedName("item_quantity")
	val itemQuantity: String? = null,

	@field:SerializedName("item_disc_amount")
	val itemDiscAmount: String? = null
)

data class CustomerCategory3(

	@field:SerializedName("category_name")
	val categoryName: String? = null,

	@field:SerializedName("category_code")
	val categoryCode: String? = null,

	@field:SerializedName("id")
	val id: Int? = null
)

data class Customer(

	@field:SerializedName("cust_nib")
	val custNib: String? = null,

	@field:SerializedName("cust_ppoe_suspend_profile")
	val custPpoeSuspendProfile: String? = null,

	@field:SerializedName("mst_server_connection_id")
	val mstServerConnectionId: Int? = null,

	@field:SerializedName("cust_interface")
	val custInterface: Any? = null,

	@field:SerializedName("cust_address")
	val custAddress: String? = null,

	@field:SerializedName("cust_npwp")
	val custNpwp: String? = null,

	@field:SerializedName("customer_category")
	val customerCategory: CustomerCategory3? = null,

	@field:SerializedName("cust_ppoe_profile")
	val custPpoeProfile: String? = null,

	@field:SerializedName("cust_phone_number")
	val custPhoneNumber: String? = null,

	@field:SerializedName("cust_ip_address")
	val custIpAddress: Any? = null,

	@field:SerializedName("cust_sales_uname")
	val custSalesUname: String? = null,

	@field:SerializedName("cust_code")
	val custCode: String? = null,

	@field:SerializedName("cust_category_id")
	val custCategoryId: Int? = null,

	@field:SerializedName("cust_email")
	val custEmail: String? = null,

	@field:SerializedName("cust_name")
	val custName: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("cust_site")
	val custSite: String? = null,

	@field:SerializedName("cust_city")
	val custCity: String? = null
)

data class InvoicesItem(

	@field:SerializedName("trx_sales_invoice_payments")
	val trxSalesInvoicePayments: List<TrxSalesInvoicePaymentsItem?>? = null,

	@field:SerializedName("si_disc_amount")
	val siDiscAmount: String? = null,

	@field:SerializedName("si_tax_percent")
	val siTaxPercent: String? = null,

	@field:SerializedName("si_created_date")
	val siCreatedDate: String? = null,

	@field:SerializedName("si_notes")
	val siNotes: Any? = null,

	@field:SerializedName("si_status")
	val siStatus: String? = null,

	@field:SerializedName("si_created_by")
	val siCreatedBy: String? = null,

	@field:SerializedName("trx_sales_invoice_items")
	val trxSalesInvoiceItems: List<TrxSalesInvoiceItemsItem?>? = null,

	@field:SerializedName("si_due_date")
	val siDueDate: String? = null,

	@field:SerializedName("total_payment_amount")
	val totalPaymentAmount: Int? = null,

	@field:SerializedName("cancel_reason")
	val cancelReason: Any? = null,

	@field:SerializedName("si_total")
	val siTotal: String? = null,

	@field:SerializedName("si_code")
	val siCode: String? = null,

	@field:SerializedName("si_tax_amount")
	val siTaxAmount: String? = null,

	@field:SerializedName("remaining_payment")
	val remainingPayment: Int? = null,

	@field:SerializedName("cancel_date")
	val cancelDate: Any? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("cancel_by")
	val cancelBy: Any? = null,

	@field:SerializedName("customer_id")
	val customerId: Int? = null,

	@field:SerializedName("si_grand_total")
	val siGrandTotal: String? = null,

	@field:SerializedName("customer")
	val customer: Customer? = null
)

data class Data3(

	@field:SerializedName("invoices")
	val invoices: List<InvoicesItem?>? = null
)

data class Meta3(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class TrxSalesInvoicePaymentsItem(

	@field:SerializedName("si_id")
	val siId: Int? = null,

	@field:SerializedName("uid")
	val uid: Any? = null,

	@field:SerializedName("cdt")
	val cdt: String? = null,

	@field:SerializedName("si_code")
	val siCode: String? = null,

	@field:SerializedName("udt")
	val udt: String? = null,

	@field:SerializedName("payment_amount")
	val paymentAmount: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("payment_created_date")
	val paymentCreatedDate: String? = null,

	@field:SerializedName("payment_created_by")
	val paymentCreatedBy: String? = null,

	@field:SerializedName("payment_file")
	val paymentFile: Any? = null,

	@field:SerializedName("cid")
	val cid: Int? = null
)
