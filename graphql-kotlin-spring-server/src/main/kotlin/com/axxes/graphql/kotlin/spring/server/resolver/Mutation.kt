package com.axxes.graphql.kotlin.spring.server.resolver

import com.axxes.graphql.core.model.CompetenceCenter
import com.axxes.graphql.core.repository.EmployeeRepository
import com.axxes.graphql.kotlin.spring.server.dto.CompetenceCenterDto
import com.axxes.graphql.kotlin.spring.server.dto.EmployeeInput
import com.axxes.graphql.kotlin.spring.server.dto.support.DtoMapper
import com.expediagroup.graphql.spring.operations.Mutation
import org.springframework.stereotype.Component

@Component
class Mutation(
        private val employeeRepository: EmployeeRepository,
        private val dtoMapper: DtoMapper
) : Mutation {

    fun createEmployee(employeeInput: EmployeeInput) = with(employeeInput) {
        dtoMapper.toDto(employeeRepository.create(firstName, lastName, email, competenceCenters.toDomain()))
    }

    private fun List<CompetenceCenterDto>.toDomain(): Set<CompetenceCenter> =
            this.mapNotNull { dtoMapper.toDomain(it) }.toSet()
}