package pwaksman.entity

import java.math.BigDecimal

class FreeAdditional(additional: Additional) : Additional("${additional.name} (combo)", BigDecimal("0.00"))