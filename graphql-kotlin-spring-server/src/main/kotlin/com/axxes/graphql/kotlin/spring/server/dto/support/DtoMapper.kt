package com.axxes.graphql.kotlin.spring.server.dto.support

import com.axxes.graphql.core.model.CompetenceCenter
import com.axxes.graphql.core.model.Employee
import com.axxes.graphql.kotlin.spring.server.dto.CompetenceCenterDto
import com.axxes.graphql.kotlin.spring.server.dto.EmployeeDto
import org.springframework.stereotype.Component

@Component
class DtoMapper {
    fun toDomain(competenceCenter: CompetenceCenterDto?) = competenceCenter?.let { CompetenceCenter.valueOf(it.name) }

    fun toDto(employee: Employee) = with(employee) {
        EmployeeDto(
                id = id,
                firstName = firstName,
                lastName = lastName,
                email = email,
                competenceCenters = competenceCenters.map { it.toDto() }
        )
    }

    private fun CompetenceCenter.toDto() = CompetenceCenterDto.valueOf(name)
}