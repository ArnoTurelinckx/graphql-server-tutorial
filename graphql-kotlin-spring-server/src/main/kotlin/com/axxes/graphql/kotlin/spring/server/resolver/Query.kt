package com.axxes.graphql.kotlin.spring.server.resolver

import com.axxes.graphql.core.repository.EmployeeRepository
import com.axxes.graphql.kotlin.spring.server.dto.CompetenceCenterDto
import com.axxes.graphql.kotlin.spring.server.dto.support.DtoMapper
import com.expediagroup.graphql.spring.operations.Query
import org.springframework.stereotype.Component

@Component
class Query(
        private val employeeRepository: EmployeeRepository,
        private val dtoMapper: DtoMapper
) : Query {

    fun allEmployees(competenceCenter: CompetenceCenterDto?) =
            employeeRepository.findAllEmployees(dtoMapper.toDomain(competenceCenter))
                    .map(dtoMapper::toDto)
}
