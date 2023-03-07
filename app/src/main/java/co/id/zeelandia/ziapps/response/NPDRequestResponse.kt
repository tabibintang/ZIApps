package co.id.zeelandia.ziapps.response

import com.google.gson.annotations.SerializedName

//data class NPDRequestResponse(
//	val npdRequest: List<NPDRequest>,
//)

data class NPDRequestResponse(

	@field:SerializedName("ProdGroupId")
	val prodGroupId: String,

	@field:SerializedName("ReqRnQMgrSignDate")
	val reqRnQMgrSignDate: String,

	@field:SerializedName("ReqSegments")
	val reqSegments: String,

	@field:SerializedName("ReqTPDate")
	val reqTPDate: Any,

	@field:SerializedName("OldProductName")
	val oldProductName: Any,

	@field:SerializedName("ReqId")
	val reqId: String,

	@field:SerializedName("ModifiedBy")
	val modifiedBy: String,

	@field:SerializedName("ReqProdId")
	val reqProdId: String,

	@field:SerializedName("ReqOpGenReg")
	val reqOpGenReg: String,

	@field:SerializedName("ReqPackType")
	val reqPackType: String,

	@field:SerializedName("AttachmentName")
	val attachmentName: String,

	@field:SerializedName("ReqEstLead")
	val reqEstLead: Any,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("ReqComHead")
	val reqComHead: String,

	@field:SerializedName("ReqRndMgrSign")
	val reqRndMgrSign: String,

	@field:SerializedName("ReqTPSign")
	val reqTPSign: Any,

	@field:SerializedName("PostphoneComment")
	val postphoneComment: Any,

	@field:SerializedName("ReqType")
	val reqType: String,

	@field:SerializedName("ReqAppStats")
	val reqAppStats: String,

	@field:SerializedName("ReqSign")
	val reqSign: String,

	@field:SerializedName("CreatedBy")
	val createdBy: String,

	@field:SerializedName("ReqProdType")
	val reqProdType: String,

	@field:SerializedName("ReqFeasComm")
	val reqFeasComm: String,

	@field:SerializedName("AttachmentCls")
	val attachmentCls: String,

	@field:SerializedName("ReviseComment")
	val reviseComment: Any,

	@field:SerializedName("ReqRndHeadSign")
	val reqRndHeadSign: Any,

	@field:SerializedName("ReqOpIndCus")
	val reqOpIndCus: String,

	@field:SerializedName("ReqTargetLaunchRND")
	val reqTargetLaunchRND: String,

	@field:SerializedName("CreatedDate")
	val createdDate: String,

	@field:SerializedName("ReqDate")
	val reqDate: String,

	@field:SerializedName("TerminationComment")
	val terminationComment: Any,

	@field:SerializedName("ReqCustName")
	val reqCustName: String,

	@field:SerializedName("NPDStatus")
	val nPDStatus: String,

	@field:SerializedName("ReqPos")
	val reqPos: String,

	@field:SerializedName("ReqOpExp")
	val reqOpExp: String,

	@field:SerializedName("ReqRndHead")
	val reqRndHead: Any,

	@field:SerializedName("created_at")
	val createdAt: String,

	@field:SerializedName("ReqMaxSalesPrice")
	val reqMaxSalesPrice: String,

	@field:SerializedName("ModifiedDate")
	val modifiedDate: String,

	@field:SerializedName("ReqTPId")
	val reqTPId: Any,

	@field:SerializedName("ReviseDate")
	val reviseDate: Any,

	@field:SerializedName("ReqBenchmark")
	val reqBenchmark: String,

	@field:SerializedName("TermSuggestComment")
	val termSuggestComment: Any,

	@field:SerializedName("TermSuggestDate")
	val termSuggestDate: Any,

	@field:SerializedName("ReqCategory")
	val reqCategory: String,

	@field:SerializedName("ReqEstLead1")
	val reqEstLead1: Any,

	@field:SerializedName("updated_at")
	val updatedAt: String,

	@field:SerializedName("ReqComHeadSign")
	val reqComHeadSign: String,

	@field:SerializedName("ReqNewProds")
	val reqNewProds: Any,

	@field:SerializedName("PDMSign")
	val pDMSign: Any,

	@field:SerializedName("ReqPICRND")
	val reqPICRND: Any,

	@field:SerializedName("PDM")
	val pDM: Any,

	@field:SerializedName("ReqNewIngre")
	val reqNewIngre: Any,

	@field:SerializedName("ReqPackSize")
	val reqPackSize: String,

	@field:SerializedName("ReqRnQMgr")
	val reqRnQMgr: String,

	@field:SerializedName("TerminationDate")
	val terminationDate: Any,

	@field:SerializedName("ReqProdVarian")
	val reqProdVarian: String,

	@field:SerializedName("ReqNote1")
	val reqNote1: String,

	@field:SerializedName("ReqComHeadSignDate")
	val reqComHeadSignDate: String,

	@field:SerializedName("ReqNote2")
	val reqNote2: Any,

	@field:SerializedName("ReqNote3")
	val reqNote3: String,

	@field:SerializedName("ReqNo")
	val reqNo: String,

	@field:SerializedName("PostponeDate")
	val postponeDate: Any,

	@field:SerializedName("ReqOpNatLoc")
	val reqOpNatLoc: String,

	@field:SerializedName("ReqRndHeadSignDate")
	val reqRndHeadSignDate: Any,

	@field:SerializedName("PDMSignDate")
	val pDMSignDate: Any,

	@field:SerializedName("ReqPotentialSales")
	val reqPotentialSales: String,

	@field:SerializedName("ReqTargetLaunch")
	val reqTargetLaunch: String,

	@field:SerializedName("ReqTechFeas")
	val reqTechFeas: Any,

	@field:SerializedName("ReqSignDate")
	val reqSignDate: String,

	@field:SerializedName("ReqSpecRequest")
	val reqSpecRequest: String
)
