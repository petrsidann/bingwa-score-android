package com.example.bingwahybrid.presentation.viewmodel;

import com.example.bingwahybrid.domain.auth.repository.AuthRepository;
import com.example.bingwahybrid.domain.auth.usecase.UpdateAgentUseCase;
import dagger.internal.Factory;
import dagger.internal.Provider;

/* JADX INFO: loaded from: classes3.dex */
public final class EditProfileViewModel_Factory implements Factory<EditProfileViewModel> {
    private final Provider<AuthRepository> authRepositoryProvider;
    private final Provider<UpdateAgentUseCase> updateAgentUseCaseProvider;

    private EditProfileViewModel_Factory(Provider<AuthRepository> authRepositoryProvider, Provider<UpdateAgentUseCase> updateAgentUseCaseProvider) {
        this.authRepositoryProvider = authRepositoryProvider;
        this.updateAgentUseCaseProvider = updateAgentUseCaseProvider;
    }

    @Override // javax.inject.Provider, jakarta.inject.Provider
    public EditProfileViewModel get() {
        return newInstance(this.authRepositoryProvider.get(), this.updateAgentUseCaseProvider.get());
    }

    public static EditProfileViewModel_Factory create(Provider<AuthRepository> authRepositoryProvider, Provider<UpdateAgentUseCase> updateAgentUseCaseProvider) {
        return new EditProfileViewModel_Factory(authRepositoryProvider, updateAgentUseCaseProvider);
    }

    public static EditProfileViewModel newInstance(AuthRepository authRepository, UpdateAgentUseCase updateAgentUseCase) {
        return new EditProfileViewModel(authRepository, updateAgentUseCase);
    }
}
