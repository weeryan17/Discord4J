/*
 *     This file is part of Discord4J.
 *
 *     Discord4J is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Discord4J is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with Discord4J.  If not, see <http://www.gnu.org/licenses/>.
 */

package sx.blah.discord.handle.impl.obj;

import sx.blah.discord.api.internal.DiscordClientImpl;
import sx.blah.discord.handle.obj.*;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.Image;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;

import java.util.*;

public class PrivateChannel extends Channel implements IPrivateChannel {

	/**
	 * The recipient of this private channel.
	 */
	protected final IUser recipient;

	public PrivateChannel(DiscordClientImpl client, IUser recipient, String id) {
		super(client, recipient.getName(), id, null, null, 0, new HashMap<>(), new HashMap<>());
		this.recipient = recipient;
	}

	@Override
	public Map<String, PermissionOverride> getUserOverrides() {
		return new HashMap<>();
	}

	@Override
	public Map<String, PermissionOverride> getRoleOverrides() {
		return new HashMap<>();
	}

	@Override
	public EnumSet<Permissions> getModifiedPermissions(IUser user) {
		if (user != null && (user.equals(recipient) || user.equals(client.getOurUser())))
			return EnumSet.allOf(Permissions.class);

		return EnumSet.noneOf(Permissions.class);
	}

	@Override
	public EnumSet<Permissions> getModifiedPermissions(IRole role) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addUserOverride(String userId, PermissionOverride override) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void addRoleOverride(String roleId, PermissionOverride override) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removePermissionsOverride(IUser user) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void removePermissionsOverride(IRole role) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void overrideRolePermissions(IRole role, EnumSet<Permissions> toAdd, EnumSet<Permissions> toRemove) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void overrideUserPermissions(IUser user, EnumSet<Permissions> toAdd, EnumSet<Permissions> toRemove) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<IInvite> getInvites() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setPosition(int position) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getPosition() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void changeName(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void changePosition(int position) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void changeTopic(String topic) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String mention() {
		return recipient.mention();
	}

	@Override
	public IInvite createInvite(int maxAge, int maxUses, boolean temporary, boolean unique) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setTopic(String topic) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String getTopic() {
		return "";
	}

	@Override
	public IGuild getGuild() {
		return null;
	}

	@Override
	public String getName() {
		return recipient.getName();
	}

	@Override
	public void setName(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<IMessage> getPinnedMessages() {
		return new ArrayList<>();
	}

	@Override
	public List<IWebhook> getWebhooks() {
		throw new UnsupportedOperationException();
	}

	@Override
	public IWebhook getWebhookByID(String id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<IWebhook> getWebhooksByName(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IWebhook createWebhook(String name) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IWebhook createWebhook(String name, Image avatar) {
		throw new UnsupportedOperationException();
	}

	@Override
	public IWebhook createWebhook(String name, String avatar) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void loadWebhooks() {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<IUser> getUsersHere() {
		return Collections.singletonList(recipient);
	}

	@Override
	public IUser getRecipient() {
		return recipient;
	}

	@Override
	public String toString() {
		return recipient.toString();
	}

	@Override
	public IPrivateChannel copy() {
		return new PrivateChannel(client, recipient, id);
	}

	@Override
	public boolean isDeleted() {
		return false;
	}
}
